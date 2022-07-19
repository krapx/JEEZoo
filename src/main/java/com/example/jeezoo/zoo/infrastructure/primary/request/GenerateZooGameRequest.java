package com.example.jeezoo.zoo.infrastructure.primary.request;

import com.example.jeezoo.space.exposition.request.GenerateSpaceRequest;

import java.util.List;

public final class GenerateZooGameRequest {
    public List<GenerateSpaceRequest> spaces;

    @Override
    public String toString() {
        return "GenerateZooGameRequest{" +
            "generateSpaces=" + spaces +
            '}';
    }
}

