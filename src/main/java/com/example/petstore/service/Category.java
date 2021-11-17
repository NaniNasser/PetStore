package com.example.petstore.service;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Category {

    @OneToMany
    public Pet pet;

}
