package com.example.jeezoo.fight.application.query;

import com.example.jeezoo.fight.application.query.ReadFightByIdQuery;
import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightId;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.kernel.cqs.QueryHandler;

public final class ReadFightByIdQueryHandler implements QueryHandler<ReadFightByIdQuery, Fight> {

    private final FightService fightService;

    public ReadFightByIdQueryHandler(FightService fightService) {
        this.fightService = fightService;
    }

    @Override
    public Fight handle(ReadFightByIdQuery query) {
        return fightService.getById(new FightId(query.getId()));
    }
}
