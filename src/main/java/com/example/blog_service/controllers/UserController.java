package com.example.blog_service.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_service.models.ApiResponse;
import com.example.blog_service.models.UserModel;
import com.example.blog_service.services.UserModelService;

@RestController
public class UserController {

    @Autowired
    UserModelService userModelService;

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<UserModel>> addUser(@RequestBody UserModel user) {

        try {
            UserModel newUser = new UserModel();
            newUser.setEmail(user.getEmail());
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            newUser.setNumber(user.getNumber());
            newUser.setDesignation(user.getDesignation());
            newUser.setIntro(user.getIntro());
            newUser.setIsActive(true);
            newUser.setLinks(null);
            newUser.setUserImageLink(user.getUserImageLink()); // TODO: add image upload logic here

            userModelService.addUser(newUser);

            return ResponseEntity.ok(new ApiResponse<>(201, "Success", newUser));

        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest()
                    .body(new ApiResponse<>(500, "Error while adding user", null));
        }

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<UserModel>> getSingleUser(@PathVariable String userId) {
        try {
            Optional<UserModel> user = userModelService.getUserById(userId);
            if (user.isPresent()) {
                return ResponseEntity.ok(new ApiResponse<>(200, "Success", user.get()));

            } else {
                ApiResponse<UserModel> response = new ApiResponse<>(404, "User not Avaiable",
                        null);
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest()
                   .body(new ApiResponse<>(500, "Error while fetching user", null));
        }
    }

}
