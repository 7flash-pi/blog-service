package com.example.blog_service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_service.models.BlogModel;

@Repository()
public interface  BlogModelRepository  extends MongoRepository<BlogModel, String>{
    
}
