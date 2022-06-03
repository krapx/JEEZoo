package com.example.jeezoo.space.domain;

import lombok.Getter;

@Getter
public class SpaceId {

    private final Long value;
    private static final Long NOT_CREATED_YET = -1L;

    public SpaceId(Long value) {
        this.value = value;
    }

    public SpaceId() {
        this.value = NOT_CREATED_YET;
    }
}
