package com.example.jeezoo.animal.infrastructure.primary.request;

public record AddAnimalRequest(
    String name,
    String type,
    String status,
    float lengthMax,
    float weightMax,
    String imageLink,
    Long spaceId
) {
}
