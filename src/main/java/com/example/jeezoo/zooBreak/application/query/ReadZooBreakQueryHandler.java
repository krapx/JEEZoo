package com.example.jeezoo.zooBreak.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakQuery;
import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;

import java.util.List;

public final class ReadZooBreakQueryHandler implements QueryHandler<ReadZooBreakQuery, List<ZooBreak>> {

    private final ZooBreakService zooBreakService;

    public ReadZooBreakQueryHandler(ZooBreakService zooBreakService) {
        this.zooBreakService = zooBreakService;
    }

    @Override
    public List<ZooBreak> handle(ReadZooBreakQuery query) {
        return zooBreakService.getAll();
    }
}
