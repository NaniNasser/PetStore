package com.example.petstore.datamodels;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Accessors(chain = true)
public class Pet {

    @Id
    @GeneratedValue
    private Long Id;

    @ManyToOne
    private Category category;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<String> photoUrls;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    private PetStatus status;

}
