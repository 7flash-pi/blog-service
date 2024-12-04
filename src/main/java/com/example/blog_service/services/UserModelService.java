package com.example.blog_service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_service.models.UserModel;
import com.example.blog_service.repo.UserModelRepository;

@Service()
public class UserModelService {

    @Autowired
    UserModelRepository userModelRepository;

    public Optional<UserModel> getUserById(String userId){
        return userModelRepository.findById(userId);
    }
    
    public UserModel addUser(UserModel user){
        return userModelRepository.save(user);
    }
    
}
