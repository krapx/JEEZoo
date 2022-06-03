package com.example.jeezoo.space.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.space.application.query.ReadSpaceQuery;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceService;

import java.util.List;

public final class ReadSpaceQueryHandler implements QueryHandler<ReadSpaceQuery, List<Space>> {

    private final SpaceService spaceService;

    public ReadSpaceQueryHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public List<Space> handle(ReadSpaceQuery query) {
        return spaceService.getAll();
    }
}
