package com.example.petstore.service;

import javax.persistence.ManyToOne;

public class Category {

    @ManyToOne
    public Pet pet;

}
