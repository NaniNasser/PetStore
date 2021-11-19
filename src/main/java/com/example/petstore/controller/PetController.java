package com.example.petstore.controller;

import com.example.petstore.datamodels.ApiResponse;
import com.example.petstore.datamodels.Pet;
import com.example.petstore.datamodels.PetStatus;
import com.example.petstore.repositories.PetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetDAO petDAO;

    @PostMapping
    public ResponseEntity<ApiResponse> postPet(@RequestBody Pet pet) {
        if (pet.getId() != null && pet.getId() > 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(405, "Bad request", " pet already exist."));

        } else {
            petDAO.save(pet);
            return ResponseEntity.ok(new ApiResponse(200, "OK", "Pet saved to database"));
        }

    }


    @PutMapping
    public ResponseEntity<ApiResponse> putPet(@RequestBody Pet pet) {
        if (pet.getId() == null || pet.getId() == 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(404, "not found", " pet not found."));

        } else {
            petDAO.save(pet);
            return ResponseEntity.ok(new ApiResponse(200, "OK", "Pet updated to the database"));
        }

    }

    @GetMapping("/findByStatus")
    public ResponseEntity getPetByStatus(@RequestParam("status") String[] status) {


        try {
            PetStatus[] petStatus = new PetStatus[status.length];

            for (int i = 0; i < status.length; i++) {
                petStatus[i] = PetStatus.valueOf(status[i].toUpperCase());
            }
            List<Pet> allByStatus = petDAO.findAllByStatus(petStatus);

            return ResponseEntity.ok(allByStatus);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ApiResponse(400, "Bad request", "Invalid status value"));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity getPetById(@PathVariable("id") Long id) {
        if (id == null || id == 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(404, "not found", " pet not found."));
        } else {
            Optional<Pet> byId = petDAO.findById(id);
            if (byId.isPresent())
                return ResponseEntity.ok(byId.get());
            else {
                return ResponseEntity.badRequest().body(new ApiResponse(404, "not found", " pet not found."));
            }
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePetById(@PathVariable("id") Long id) {
        if (id == null || id == 0) {
            return ResponseEntity.badRequest().body(new ApiResponse(404, "not found", " pet not found."));
        } else {
            petDAO.deleteById(id);
            return ResponseEntity.ok(new ApiResponse(200,"OK","Pet deleted from the database"));
        }
    }
}



