package com.example.jeezoo.zoo.infrastructure.primary.request;

import com.example.jeezoo.space.exposition.request.GenerateSpaceRequest;
import lombok.Data;

import java.util.List;

public record GenerateZooGameRequest(
    Long userId,
    List<GenerateSpaceRequest> spaces
) {
}