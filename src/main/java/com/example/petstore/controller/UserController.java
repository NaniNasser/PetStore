package com.example.petstore.controller;

import com.example.petstore.datamodels.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path="/user")
    public ResponseEntity<User> getUser(String id) {
        if ("1".equals(id)) {
            User user = new User();
           // user.setId();
            user.setLastName("Nani");
            return ResponseEntity.ok(user);

        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found");
        }
    }
}

