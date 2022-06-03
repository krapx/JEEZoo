package com.example.jeezoo.space.infrastructure;

import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import org.springframework.stereotype.Component;

@Component
public final class SpaceMapper {

    public SpaceEntity toEntity(Space space) {
        return new SpaceEntity().id(space.getId().getValue()).title(space.getTitle());
    }

    public Space toModel(SpaceEntity spaceEntity) {
        return Space.of(new SpaceId(spaceEntity.getId()), spaceEntity.getTitle());
    }
}
