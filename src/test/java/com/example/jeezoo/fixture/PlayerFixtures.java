package com.example.jeezoo.fixture;

import com.example.jeezoo.player.infrastructure.primary.CreatePlayerRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class PlayerFixtures {

    public static Response register(
        String username,
        String password,
        String email
    ) {
        CreatePlayerRequest request = new CreatePlayerRequest(username, password, email);
        return given().contentType(ContentType.JSON).body(request).when().post("/register");
    }
}
