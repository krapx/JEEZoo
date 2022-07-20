package com.example.jeezoo.playerAnimal.domain.exception;

public class PlayerAnimalBadArgumentException extends RuntimeException {

    public PlayerAnimalBadArgumentException() {
        super("PlayerAnimal should doesn't have an id");
    }
}
