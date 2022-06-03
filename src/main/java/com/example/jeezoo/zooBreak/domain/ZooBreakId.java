package com.example.jeezoo.zooBreak.domain;

import lombok.Getter;

@Getter
public class ZooBreakId {

    private final Long value;
    private static final Long NOT_CREATED_YET = -1L;

    public ZooBreakId(Long value) {
        this.value = value;
    }

    public ZooBreakId() {
        this.value = NOT_CREATED_YET;
    }
}
