package com.example.petstore.controller;

import com.example.petstore.datamodels.ApiResponse;
import com.example.petstore.datamodels.User;
import com.example.petstore.repositories.PetDAO;
import com.example.petstore.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostMapping
    public ResponseEntity<ApiResponse> postUser(@RequestBody User user) {
        if (user.getId() != null && user.getId() > 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(404, "Not found", "User not found."));
        } else {
            userDAO.save(user);
            return ResponseEntity.ok(new ApiResponse(200, "OK", "User saved to the database"));
        }
    }
}








