package com.example.jeezoo.animal.infrastructure.primary;

import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.fixture.AnimalFixtures;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
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
        String location = AnimalFixtures
            .addAnimal("name", "type", "Alive", 1L, 1L, "imageLink", 1L)
            .then()
            .statusCode(201)
            .extract()
            .header("Location");

        assertThat(location).isNotEmpty();

        AnimalResponse animalResponse = when()
            .get(location)
            .then()
            .statusCode(200)
            .extract()
            .body()
            .jsonPath()
            .getObject(".", AnimalResponse.class);

        assertThat(animalResponse.getName()).isEqualTo("name");
    }

    @Test
    void getAnimalById() {
    }
}