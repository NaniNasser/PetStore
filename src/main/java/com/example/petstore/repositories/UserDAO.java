package com.example.petstore.repositories;

import com.example.petstore.datamodels.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {

}
