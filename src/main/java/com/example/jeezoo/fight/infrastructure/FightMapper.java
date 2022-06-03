package com.example.jeezoo.fight.infrastructure;

import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightId;
import org.springframework.stereotype.Component;

@Component
public final class FightMapper {

    public FightEntity toEntity(Fight fight) {
        return new FightEntity().id(fight.getId().getValue()).title(fight.getTitle());
    }

    public Fight toModel(FightEntity fightEntity) {
        return Fight.of(new FightId(fightEntity.getId()), fightEntity.getTitle());
    }
}
