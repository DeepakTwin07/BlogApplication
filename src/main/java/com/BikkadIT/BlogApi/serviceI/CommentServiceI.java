package com.BikkadIT.BlogApi.serviceI;

import com.BikkadIT.BlogApi.payload.CommentDto;

public interface CommentServiceI {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);
}
