package com.example.jeezoo.space.domain.exception;

import com.example.jeezoo.space.domain.SpaceId;

public class SpaceNotFoundException extends RuntimeException {
    public SpaceNotFoundException(SpaceId id) {
        super("Space with id \"" + id.getValue() + "\" not found");
    }
}
