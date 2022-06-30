package com.example.jeezoo.userAnimal.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class UserAnimalId {

    private final Long value;

    public static UserAnimalId create() {
        return new UserAnimalId(-1L);
    }
}
