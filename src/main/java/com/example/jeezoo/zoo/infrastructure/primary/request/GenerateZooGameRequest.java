package com.example.jeezoo.zoo.infrastructure.primary.request;

import com.example.jeezoo.playerAnimal.infrastructure.primary.CreatePlayerAnimalPartiallyRequest;
import com.example.jeezoo.space.exposition.request.GenerateSpaceRequest;

import javax.validation.constraints.NotNull;
import java.util.List;

public record GenerateZooGameRequest(
    @NotNull
    CreatePlayerAnimalPartiallyRequest playerAnimal,
    @NotNull
    List<GenerateSpaceRequest> spaces
) {
}