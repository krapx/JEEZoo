package com.example.jeezoo.space.domain;

import lombok.Data;
import lombok.Getter;

@Data(staticConstructor = "of")
public class SpaceId {

    private final Long value;
    private static final Long NOT_CREATED_YET = -1L;

    public static SpaceId notCreatedYet() {
        return SpaceId.of(NOT_CREATED_YET);
    }
}
