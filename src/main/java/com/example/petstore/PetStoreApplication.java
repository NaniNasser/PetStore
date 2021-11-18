package com.example.petstore;

import com.example.petstore.datamodels.Category;
import com.example.petstore.datamodels.Tag;
import com.example.petstore.repositories.CategoryRepo;
import com.example.petstore.repositories.TagRepo;
import org.hibernate.id.Configurable;
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
        CategoryRepo categoryRepo = context.getBean(CategoryRepo.class);
        TagRepo tagRepo = context.getBean(TagRepo.class);

        categoryRepo.saveAll(getCategories())
                .forEach(System.out::println);

        tagRepo.saveAll(getTags())
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


}
