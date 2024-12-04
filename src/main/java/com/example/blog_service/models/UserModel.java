package com.example.blog_service.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {
    private String name;
    private String email;
    private String designation;
    private String intro;
    private String password;
    private boolean isActive;
    private String number;
    private SocialLinks socialLinks;
    private String userImageLink;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public SocialLinks getLinks() {
        return socialLinks;
    }

    public void setLinks(SocialLinks links) {
        this.socialLinks = links;
    }

    public String getUserImageLink() {
        return userImageLink;
    }

    public void setUserImageLink(String userImageLink) {
        this.userImageLink = userImageLink;
    }

}
