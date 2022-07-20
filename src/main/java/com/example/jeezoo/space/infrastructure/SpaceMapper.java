package com.example.jeezoo.space.infrastructure;

import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceStatus;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.stereotype.Component;

@Component
public final class SpaceMapper {

    public SpaceEntity toEntity(Space space) {
        return new SpaceEntity()
            .id(space.getId().getValue())
            .name(space.getName())
            .status(space.getStatus().name())
            .zooId(space.getZooId().getValue());
    }

    public Space toModel(SpaceEntity spaceEntity) {
        return Space.of(
            SpaceId.of(spaceEntity.getId()),
            spaceEntity.getName(),
            SpaceStatus.valueOf(spaceEntity.getStatus()),
            ZooId.of(spaceEntity.getZooId())
        );
    }
}
