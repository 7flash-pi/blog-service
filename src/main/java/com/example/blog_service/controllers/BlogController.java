package com.example.blog_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_service.dto.BlogRequest;
import com.example.blog_service.models.ApiResponse;
import com.example.blog_service.models.BlogCategory;
import com.example.blog_service.models.BlogModel;
import com.example.blog_service.services.BlogCategoryService;
import com.example.blog_service.services.BlogModelServices;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    @Autowired
    BlogModelServices blogModelServices;
    @Autowired
    BlogCategoryService blogCategoryService;

    @GetMapping("/blogs")
    public ResponseEntity<ApiResponse<List<BlogModel>>> getAllCategories() {

        try {
            List<BlogModel> categories = blogModelServices.getblogs();
            return ResponseEntity.ok(new ApiResponse<>(200, "Success", categories));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(500, "Error while fetching blog categories", null));
        }

    }

    @PostMapping("/blog")
    public ResponseEntity<ApiResponse<BlogModel>> createBlog(@RequestBody BlogRequest blogRequest) {
        try {
            // Convert the request DTO to the entity
            BlogModel blog = new BlogModel();
            blog.setTitle(blogRequest.getTitle());
            blog.setDescription(blogRequest.getDescription());
            blog.setAuthor(blogRequest.getPostedBy());
            blog.setImgLink(blogRequest.getImgLink());
            Optional<BlogCategory> cat = blogCategoryService.getBlogCategoryByName(blogRequest.getCategory());

            if (cat.isPresent()) {
                blog.setCategory(cat.get());
            } else {
                return ResponseEntity.badRequest()
                        .body(new ApiResponse<>(400, "Invalid category", null));
            }
            blog.setImgLink(blogRequest.getImgLink());
            blog.setIsActive(true);

            // Save the category using the service
            BlogModel savedBlog = blogModelServices.saveBlogs(blog);

            return ResponseEntity.ok(new ApiResponse<>(201, "Success", savedBlog));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(500, "Error while fetching blog categories", null));

        }

    }

}
