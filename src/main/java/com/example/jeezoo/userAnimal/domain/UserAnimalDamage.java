package com.example.jeezoo.userAnimal.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class UserAnimalDamage {

    private final Long value;

    public static UserAnimalDamage create() {
        return new UserAnimalDamage(2L);
    }
}
