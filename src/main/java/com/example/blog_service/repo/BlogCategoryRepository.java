package com.example.blog_service.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.blog_service.models.BlogCategory;


@Repository
public interface BlogCategoryRepository extends MongoRepository<BlogCategory, String> {
    // Custom query methods (if needed) can be added here
    Optional<BlogCategory> findByName(String name);

}
