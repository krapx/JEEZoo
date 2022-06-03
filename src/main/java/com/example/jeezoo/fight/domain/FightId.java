package com.example.jeezoo.fight.domain;

import lombok.Getter;

@Getter
public class FightId {

    private final Long value;
    private static final Long NOT_CREATED_YET = -1L;

    public FightId(Long value) {
        this.value = value;
    }

    public FightId() {
        this.value = NOT_CREATED_YET;
    }
}
