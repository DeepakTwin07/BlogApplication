package com.BikkadIT.BlogApi.serviceI;

import java.util.List;

import com.BikkadIT.BlogApi.payload.PostDto;
import com.BikkadIT.BlogApi.payload.PostResponse;

public interface PostServiceI {

		//method to create post 

		PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

		//method to update post 

		PostDto updatePost(PostDto postDto, Integer postId);

		// method to delete

		void deletePost(Integer postId);
		
		//method to get all posts
		
		PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
		
		//method to get single post
		
		PostDto getPostById(Integer postId);
		
		//method to get all posts by category
		
		List<PostDto> getPostsByCategory(Integer categoryId);
		
		//method to get all posts by user
		List<PostDto> getPostsByUser(Integer userId);
		
		//mehtod to search posts
		List<PostDto> searchPosts(String keyword);

}
