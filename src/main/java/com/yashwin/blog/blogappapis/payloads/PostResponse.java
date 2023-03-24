package com.yashwin.blog.blogappapis.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@AllArgsConstructor
@Getter
@Setter
public class PostResponse {


    private List<PostDto> content;

    private int pageNumber;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean LastPage;
    
}
