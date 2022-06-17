package com.example.jeezoo.space.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class Space {

    private final SpaceId id;
    private final String name;

    public static Space createSpace(String name) {
        return new Space(new SpaceId(), name);
    }
}
