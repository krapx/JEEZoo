package com.example.jeezoo.playerAnimal.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class PlayerAnimalDamage {

    private final Long value;

    public static PlayerAnimalDamage notCreateYet() {
        return new PlayerAnimalDamage(2L);
    }
}
