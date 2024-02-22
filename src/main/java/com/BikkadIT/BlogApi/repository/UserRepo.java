package com.BikkadIT.BlogApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.BlogApi.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
