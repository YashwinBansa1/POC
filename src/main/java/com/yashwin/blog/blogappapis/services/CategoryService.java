package com.yashwin.blog.blogappapis.services;

import java.util.List;

import com.yashwin.blog.blogappapis.payloads.CategoryDto;

public interface CategoryService {

    //create
     CategoryDto createCategory(CategoryDto categoryDto);

    //update
     CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
     void deleteCategory(Integer categoryId);

    //Get by Id
     CategoryDto getCategory(Integer categoryId);

    //Get all 
    List <CategoryDto> getCategories();
    
}
