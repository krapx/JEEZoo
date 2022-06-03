package com.example.jeezoo.space.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;

public final class ReadSpaceByIdQueryHandler implements QueryHandler<ReadSpaceByIdQuery, Space> {

    private final SpaceService spaceService;

    public ReadSpaceByIdQueryHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public Space handle(ReadSpaceByIdQuery query) {
        return spaceService.getById(new SpaceId(query.getId()));
    }
}
