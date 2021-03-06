package com.example.petstore.repositories;

import com.example.petstore.datamodels.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

}
