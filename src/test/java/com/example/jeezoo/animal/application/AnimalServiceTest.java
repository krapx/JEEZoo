package com.example.jeezoo.animal.application;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.secondary.h2.H2Animals;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.JpaAnimals;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AnimalServiceTest {

    Animals animals;
    DefaultAnimalService defaultAnimalService;
    @Autowired
    JpaAnimals jpaAnimals;

    @BeforeEach
    void setUp() {
        animals = new H2Animals(jpaAnimals);
        defaultAnimalService = new DefaultAnimalService(animals);
    }

    @Test
    void should_retrieve_initial_animal_list_when_no_animal_added() {
        var animals = defaultAnimalService.findAll();

        assertThat(animals).hasSize(2);
    }


    @Test
    void should_add_animal() {
        defaultAnimalService.addAnimal(
                "test",
                "test",
                "Alive",
                1.1f,
                1.1f,
                "test",
                1L
        );

        var animals = defaultAnimalService.findAll();

        assertThat(animals).hasSize(3);
        assertThat(animals.get(0).getName()).isEqualTo("test");

    }

    @Test
    void getAnimalById() {
        var animal = defaultAnimalService.getById(1300L);

        assertThat(animal.getName()).isEqualTo("toto");
    }
}