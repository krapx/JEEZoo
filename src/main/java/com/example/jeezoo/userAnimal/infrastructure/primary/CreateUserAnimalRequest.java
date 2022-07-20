package com.example.jeezoo.userAnimal.infrastructure.primary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreateUserAnimalRequest(
    @NotEmpty
    String name,
    @NotEmpty
    String image,
    @NotNull
    Long userId,
    @NotNull
    Long zooId
) {
}
