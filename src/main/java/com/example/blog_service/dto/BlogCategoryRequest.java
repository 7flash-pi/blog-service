package com.example.blog_service.dto;

public class BlogCategoryRequest {

    private String name;

    // Constructor
    public BlogCategoryRequest() {}

    public BlogCategoryRequest(String name) {
        this.name = name;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

