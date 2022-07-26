package com.example.jeezoo.zoo.domain.exception;

import com.example.jeezoo.zoo.domain.ZooId;

public class ZooNotFoundException extends RuntimeException {
    public ZooNotFoundException(ZooId id) {
        super("Zoo with id \"" + id.getValue() + "\" not found");
    }
}
