package com.example.petstore;

import com.example.petstore.datamodels.Category;
import com.example.petstore.datamodels.Pet;
import com.example.petstore.datamodels.PetStatus;
import com.example.petstore.datamodels.Tag;
import com.example.petstore.repositories.CategoryDAO;
import com.example.petstore.repositories.PetDAO;
import com.example.petstore.repositories.TagDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class PetStoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PetStoreApplication.class, args);
        generateData(context);
    }


    public static void generateData(ConfigurableApplicationContext context) {
        CategoryDAO categoryDAO = context.getBean(CategoryDAO.class);
        TagDAO tagDAO = context.getBean(TagDAO.class);
        PetDAO petDAO = context.getBean(PetDAO.class);

        categoryDAO.saveAll(getCategories())
                .forEach(System.out::println);

        tagDAO.saveAll(getTags())
                .forEach(System.out::println);

        petDAO.saveAll(createPets())
                .forEach(System.out::println);

    }

    public static List<Category> getCategories() {
        return List.of(
                new Category().setName("Guinea Pig"),
                new Category().setName("Cat"),
                new Category().setName("Rabbit"),
                new Category().setName("Snake"),
                new Category().setName("Dog"),
                new Category().setName("Bird"),
                new Category().setName("Hamster"),
                new Category().setName("Rat"),
                new Category().setName("Mouse"),
                new Category().setName("Lizard"),
                new Category().setName("Turtle"),
                new Category().setName("Dove"),
                new Category().setName("Fish"),
                new Category().setName("Squirrel"),
                new Category().setName("Duck"),
                new Category().setName("Chicken"),
                new Category().setName("Pig")
        );
    }

    public static List<Tag> getTags() {
        return List.of(
                new Tag().setName("male"),
                new Tag().setName("female"),
                new Tag().setName("neutered"),
                new Tag().setName("safe with kids"),
                new Tag().setName("safe with other pets"),
                new Tag().setName("trained"),
                new Tag().setName("can be home alone"),
                new Tag().setName("junior"),
                new Tag().setName("adult"),
                new Tag().setName("senior")
        );


    }

    public static List<Pet> createPets() {

        return List.of(

                new Pet().setName("Nero")
                        .setStatus(PetStatus.SOLD),
                new Pet().setName("Tosca")
                        .setStatus(PetStatus.SOLD),
                new Pet().setName("Homer")
                        .setStatus(PetStatus.PENDING),
                new Pet().setName("Marge")
                        .setStatus(PetStatus.AVAILABLE));


    }


}
