package com.yashwin.blog.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yashwin.blog.blogappapis.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    
}
