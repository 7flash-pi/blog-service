package com.example.blog_service.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_service.dto.BlogCategoryRequest;
import com.example.blog_service.models.ApiResponse;
import com.example.blog_service.models.BlogCategory;
import com.example.blog_service.services.BlogCategoryService;

@RestController
public class BlogCategoryController {

    @Autowired
    BlogCategoryService blogCategoryService;

    @GetMapping("/blog-categories")
    public ResponseEntity<ApiResponse<List<BlogCategory>>> getAllCategories() {

        try {
            List<BlogCategory> categories = blogCategoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse<>(200, "Success", categories));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(500, "Error while fetching blog categories", null));
        }

    }

    @PostMapping("/blog-categories")
    public ResponseEntity<ApiResponse<BlogCategory>> createCategory(@RequestBody BlogCategoryRequest categoryRequest) {
        try {
            // Convert the request DTO to the entity
            BlogCategory category = new BlogCategory();
            category.setName(categoryRequest.getName());
            category.setIsActive(true); // Assuming all categories are active by default
            category.setCreatedAt(LocalDateTime.now()); 
            // Assuming current timestamp for creation time

            // Save the category using the service
            BlogCategory savedCategory = blogCategoryService.createBlogCategory(category);

            return ResponseEntity.ok(new ApiResponse<>(201, "Success", savedCategory));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(500, "Error while fetching blog categories", null));

        }

    }
}
