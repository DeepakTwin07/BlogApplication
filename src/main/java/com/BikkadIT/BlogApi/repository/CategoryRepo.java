 package com.BikkadIT.BlogApi.repository;
 

 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.BlogApi.entity.Category;
 
@Repository
 public interface CategoryRepo extends JpaRepository<Category,Integer>{
 
 }
