package com.yashwin.blog.blogappapis.services;

import java.util.List;
import com.yashwin.blog.blogappapis.payloads.PostDto;
import com.yashwin.blog.blogappapis.payloads.PostResponse;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //getAllPost
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //getSinglePost
    PostDto getPostById(Integer postId);

    //GetAllPostsByCategory
    List<PostDto> getPostsByCategory(Integer categoryId);

    //getAllPostsByUser
    List<PostDto> getPostsByUser(Integer userId);

    // SearchPost
    List<PostDto> searchPosts(String keyword);

    
}
