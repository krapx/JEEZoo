package com.example.jeezoo.animal.infrastructure.primary;

import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.AnimalType;
import com.example.jeezoo.fixture.AnimalFixtures;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class AnimalControllerTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void should_add_animal() {
        AnimalFixtures.addAnimal(
            "animal_1",
            AnimalType.Lion.name(),
            AnimalStatus.Alive.name(),
            LocalDate.now(),
            1L
        );

//        when().get("/api/")
    }

    @Test
    void getAnimalById() {
    }
}