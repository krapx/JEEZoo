package com.example.jeezoo.space.domain;

import lombok.Data;

@Data(staticConstructor = "of")
public final class Space {

    private final SpaceId id;
    private final String title;

    public static Space createSpace(String title) {
        return new Space(new SpaceId(), title);
    }
}
