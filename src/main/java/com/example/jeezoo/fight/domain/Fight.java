package com.example.jeezoo.fight.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class Fight {

    private final FightId id;
    private final String title;

    public static Fight createFight(String title) {
        return new Fight(new FightId(), title);
    }
}
