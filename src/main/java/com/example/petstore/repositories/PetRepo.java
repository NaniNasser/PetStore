package com.example.petstore.repositories;

import com.example.petstore.datamodels.Pet;
import com.example.petstore.datamodels.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.status IN :petStatuses")
    List<Pet> findAllByStatus(@Param("petStatuses") PetStatus[] petStatuses);



}




