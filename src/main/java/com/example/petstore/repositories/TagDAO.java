package com.example.petstore.repositories;

import com.example.petstore.datamodels.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDAO extends JpaRepository<Tag, Long> {

}
