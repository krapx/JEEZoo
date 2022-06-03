package com.example.jeezoo.zooBreak.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakByIdQuery;
import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;

public final class ReadZooBreakByIdQueryHandler implements QueryHandler<ReadZooBreakByIdQuery, ZooBreak> {

    private final ZooBreakService zooBreakService;

    public ReadZooBreakByIdQueryHandler(ZooBreakService zooBreakService) {
        this.zooBreakService = zooBreakService;
    }

    @Override
    public ZooBreak handle(ReadZooBreakByIdQuery query) {
        return zooBreakService.getById(new ZooBreakId(query.getId()));
    }
}
