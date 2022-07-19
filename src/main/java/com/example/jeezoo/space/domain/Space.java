package com.example.jeezoo.space.domain;

import com.example.jeezoo.zoo.domain.ZooId;
import lombok.Data;

@Data(staticConstructor = "of")
public final class Space {

    private final SpaceId id;
    private final String name;
    private final SpaceStatus status;
    private final ZooId zooId;

    public static Space createSpace(String name, String status, ZooId zooId) {
        return new Space(new SpaceId(), name, SpaceStatus.valueOf(status), zooId);
    }
}
