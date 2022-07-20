package com.example.jeezoo.zoo.infrastructure.primary.request;

import com.example.jeezoo.space.exposition.request.GenerateSpaceRequest;

import java.util.List;

public record GenerateZooGameRequest(
    Long playerId,
    List<GenerateSpaceRequest> spaces
) {
}