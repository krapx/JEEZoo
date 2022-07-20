package com.example.jeezoo.animal.domain;

import lombok.Data;

import java.time.LocalDate;

@Data(staticConstructor = "of")
public final class Animal {

    private final AnimalId id;
    private final String name;
    private final String type;
    private final AnimalStatus status;
    private final float lengthMax;
    private final float weightMax;
    private final LocalDate arrivalDate;
    private final String imageLink;
    private final Long spaceId;

    public static Animal createAnimal(
        String name,
        String type,
        AnimalStatus status,
        float lengthMax,
        float weightMax,
        LocalDate arrivalDate,
        String imageLink,
        Long spaceId
    ) {
        return new Animal(
            AnimalId.of(-1L),
            name,
            type,
            status,
            lengthMax,
            weightMax,
            arrivalDate,
            imageLink,
            spaceId
        );
    }
}
