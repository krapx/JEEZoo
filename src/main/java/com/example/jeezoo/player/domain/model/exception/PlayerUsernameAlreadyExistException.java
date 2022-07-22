package com.example.jeezoo.player.domain.model.exception;

import static java.lang.String.format;

public class PlayerUsernameAlreadyExistException extends RuntimeException {

    public PlayerUsernameAlreadyExistException(String username) {
        super(format("Player with username %s already exist", username));
    }
}
