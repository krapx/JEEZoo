package com.example.jeezoo.zooBreak.domain.exception;

import com.example.jeezoo.zooBreak.domain.ZooBreakId;

public class ZooBreakNotFoundException extends RuntimeException {
    public ZooBreakNotFoundException(ZooBreakId id) {
        super("ZooBreak with id \"" + id.getValue() + "\" not found");
    }
}
