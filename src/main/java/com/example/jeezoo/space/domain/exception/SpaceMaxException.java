package com.example.jeezoo.space.domain.exception;

import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.zoo.domain.ZooId;

public class SpaceMaxException extends RuntimeException {
    public SpaceMaxException(ZooId zooId) {
        super("ZooId \"" + zooId.getValue() + "\" has reached the max number of spaces");
    }
}
