package com.yashwin.blog.blogappapis.services;

import com.yashwin.blog.blogappapis.payloads.CommentDto;

public interface CommentService {


    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);    
}
