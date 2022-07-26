package com.example.jeezoo.fixture;

import com.example.jeezoo.animal.infrastructure.primary.request.AddAnimalRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;

public final class AnimalFixtures {

    public static Response addAnimal(
        String name,
        String type,
        String status,
        float lengthMax,
        float weightMax,
        String imageLink,
        Long spaceId
    ) {
        AddAnimalRequest request = new AddAnimalRequest(name, type, status, lengthMax, weightMax, imageLink, spaceId);
        return given().contentType(ContentType.JSON).body(request).when().post("/api/animals");
    }
}
