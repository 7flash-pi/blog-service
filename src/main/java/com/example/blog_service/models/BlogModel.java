package com.example.blog_service.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blogs")
public class BlogModel {

    private String title;
    private String description;
    private String author;
    private BlogCategory blogCategory;
    private String imgLink;
    private boolean isActive;
    private SocialLinks socialLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BlogCategory getCategory() {
        return blogCategory;
    }

    public void setCategory(BlogCategory category) {
        this.blogCategory = category;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

}
