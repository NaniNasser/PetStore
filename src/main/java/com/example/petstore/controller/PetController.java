package com.example.petstore.controller;

import com.example.petstore.datamodels.ApiResponse;
import com.example.petstore.datamodels.Pet;
import com.example.petstore.repositories.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepo petRepo;

    @PostMapping
    public ResponseEntity<ApiResponse> postPet(@RequestBody Pet pet) {
        if (pet.getId() != null && pet.getId() > 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(405, "Bad request", " pet already exist."));

        }
        else{
            petRepo.save(pet);
            return ResponseEntity.ok(new ApiResponse(200, "OK", "Pet saved to database"));
        }

    }


    @PutMapping
    public ResponseEntity<ApiResponse> putPet(@RequestBody Pet pet) {
        if (pet.getId() == null || pet.getId() == 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(404, "not found", " pet not found."));

        }
        else{
            petRepo.save(pet);
            return ResponseEntity.ok(new ApiResponse(200, "OK", "Pet saved to database"));
        }

    }

}