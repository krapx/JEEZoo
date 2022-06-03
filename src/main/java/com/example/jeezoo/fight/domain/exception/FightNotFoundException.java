package com.example.jeezoo.fight.domain.exception;

import com.example.jeezoo.fight.domain.FightId;

public class FightNotFoundException extends RuntimeException {
    public FightNotFoundException(FightId id) {
        super("Fight with id \"" + id.getValue() + "\" not found");
    }
}
