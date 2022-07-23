package com.example.jeezoo.animal.domain.exception;

import com.example.jeezoo.animal.domain.AnimalId;

import static java.lang.String.format;

public class AnimalNotFoundException extends RuntimeException {

    public AnimalNotFoundException(AnimalId id) {
        super(format("Animal with id %d not found", id.getValue()));
    }
}
