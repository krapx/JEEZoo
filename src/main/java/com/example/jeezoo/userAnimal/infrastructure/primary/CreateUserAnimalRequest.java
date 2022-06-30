package com.example.jeezoo.userAnimal.infrastructure.primary;

public record CreateUserAnimalRequest(
    String name,
    String image,
    Long userId
) {
}
