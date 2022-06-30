package com.example.jeezoo.userAnimal.domain.exception;

import com.example.jeezoo.user.domain.model.UserId;

public class UserAnimalBadArgumentException extends RuntimeException {

    public UserAnimalBadArgumentException() {
        super("UserAnimal should doesn't have an id");
    }
}
