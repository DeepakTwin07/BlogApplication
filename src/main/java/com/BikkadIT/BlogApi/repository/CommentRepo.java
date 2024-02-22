package com.BikkadIT.BlogApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BikkadIT.BlogApi.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer>{

	
	
}
