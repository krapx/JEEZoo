package com.example.jeezoo.fight.application.query;

import com.example.jeezoo.fight.application.query.ReadFightQuery;
import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.kernel.cqs.QueryHandler;

import java.util.List;

public final class ReadFightQueryHandler implements QueryHandler<ReadFightQuery, List<Fight>> {

    private final FightService fightService;

    public ReadFightQueryHandler(FightService fightService) {
        this.fightService = fightService;
    }

    @Override
    public List<Fight> handle(ReadFightQuery query) {
        return fightService.getAll();
    }
}
