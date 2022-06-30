package com.example.jeezoo.animal.domain;

import com.example.jeezoo.kernel.annotations.AggregateRoot;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AggregateRoot
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
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

    public static Animal of(AnimalId id, String name, String type, String status, float lengthMax, float weightMax,
                            LocalDate arrivalDate, String imageLink, Long spaceId) {
        return new Animal(id, name, type, AnimalStatus.valueOf(status), lengthMax,
                weightMax, arrivalDate, imageLink, spaceId);
    }

    public static Animal createAnimal(
        String name, String type, String status, float lengthMax, float weightMax,
        LocalDate arrivalDate, String imageLink, Long spaceId
    ) {
        return of(AnimalId.of(-1L), name, type, status, lengthMax, weightMax, arrivalDate, imageLink, spaceId);
    }
}
