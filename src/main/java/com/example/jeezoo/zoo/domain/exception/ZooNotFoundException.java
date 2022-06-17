package com.example.jeezoo.zoo.domain.exception;

import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;

public class ZooNotFoundException extends RuntimeException {
    public ZooNotFoundException(ZooId id) {
        super("Zoo with id \"" + id.getValue() + "\" not found");
    }
}
