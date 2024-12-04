package com.example.blog_service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_service.models.BlogCategory;
import com.example.blog_service.repo.BlogCategoryRepository;

@Service
public class BlogCategoryService {

    @Autowired
    BlogCategoryRepository blogCategoryRepository;

    public BlogCategory createBlogCategory(BlogCategory category) {
        return blogCategoryRepository.save(category);
    }

     public List<BlogCategory> getAllCategories() {
        return blogCategoryRepository.findAll();
    }
     public Optional<BlogCategory> getBlogCategoryById(String id){
        return blogCategoryRepository.findById(id);
     }

     public Optional<BlogCategory> getBlogCategoryByName(String name){
        return blogCategoryRepository.findByName(name);
     }

     

    
}
