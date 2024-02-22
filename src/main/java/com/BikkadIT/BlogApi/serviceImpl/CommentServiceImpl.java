package com.BikkadIT.BlogApi.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.BlogApi.entity.Comment;
import com.BikkadIT.BlogApi.entity.Post;
import com.BikkadIT.BlogApi.exception.ResourseNotFoundException;
import com.BikkadIT.BlogApi.payload.CommentDto;
import com.BikkadIT.BlogApi.repository.CommentRepo;
import com.BikkadIT.BlogApi.repository.PostRepo;
import com.BikkadIT.BlogApi.serviceI.CommentServiceI;

@Service
public class CommentServiceImpl implements CommentServiceI{
	
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourseNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourseNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
		
	}

}
