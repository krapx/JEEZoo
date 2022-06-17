package com.example.jeezoo.zoo.infrastructure.primary.request;

import com.example.jeezoo.space.exposition.request.GenerateSpace;

import java.util.List;

public final class GenerateZooGameRequest {
    public List<GenerateSpace> spaces;
    public String winnerSpace;

    @Override
    public String toString() {
        return "GenerateZooGameRequest{" +
            "generateSpaces=" + spaces +
            '}';
    }
}

