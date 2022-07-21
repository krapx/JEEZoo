package com.example.jeezoo.playerAnimal.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class PlayerAnimalId {

    private final Long value;

    public static PlayerAnimalId notCreatedYet() {
        return new PlayerAnimalId(-1L);
    }
}
