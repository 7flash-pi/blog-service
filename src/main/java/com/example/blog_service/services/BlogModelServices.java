package com.example.blog_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_service.models.BlogModel;
import com.example.blog_service.repo.BlogModelRepository;

@Service()
public class BlogModelServices {

    @Autowired
    BlogModelRepository blogModelRepository;

    public BlogModel saveBlogs(BlogModel blogModel) {
        return blogModelRepository.save(blogModel);
    }

    public List<BlogModel> getblogs() {
        return blogModelRepository.findAll();
    }

    public BlogModel getBlogById(String blogId){
        return blogModelRepository.findById(blogId).orElse(null);
    }
    
    
    
}
