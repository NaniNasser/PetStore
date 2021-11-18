package com.example.petstore.datamodels;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
public class Tag {

     @Id
     @GeneratedValue
     private Long id;
     private String name;


}
