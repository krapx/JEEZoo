package com.example.jeezoo.space.domain.exception;

import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceStatus;
import com.example.jeezoo.zoo.domain.ZooId;

import static java.lang.String.format;

public class SpaceNotFoundException extends RuntimeException {
    public SpaceNotFoundException(SpaceId id) {
        super("Space with id \"" + id.getValue() + "\" not found");
    }

    public SpaceNotFoundException(ZooId id, SpaceStatus status) {
        super(format("Space with ZooId %d and Status %s not found", id.getValue(),  status));
    }
}
