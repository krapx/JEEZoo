package com.example.jeezoo.userAnimal.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class UserAnimalDamage {

    private final Long value;

    public static UserAnimalDamage notCreateYet() {
        return new UserAnimalDamage(2L);
    }
}
