package com.example.jeezoo.player.domain.model.exception;

import static java.lang.String.format;

public class PlayerUsernameNotFoundException extends RuntimeException {

    public PlayerUsernameNotFoundException(String username) {
        super(format("Player with username %s not found", username));
    }
}
