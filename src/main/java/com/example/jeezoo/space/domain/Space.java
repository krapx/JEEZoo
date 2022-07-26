package com.example.jeezoo.space.domain;

import com.example.jeezoo.zoo.domain.ZooId;
import lombok.Data;

@Data(staticConstructor = "of")
public final class Space {

    private final SpaceId id;
    private final String name;
    private final SpaceStatus status;
    private final ZooId zooId;
    private final int defeatedCount;

    public static Space createSpace(String name, String status, ZooId zooId) {

        return new Space(SpaceId.notCreatedYet(), name, SpaceStatus.valueOf(status), zooId, 0);
    }
}
