package com.example.petstore.service;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private long userStatus;
}
