package com.example.jeezoo.fight.exposition.response;

import com.example.jeezoo.fight.domain.Fight;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor(staticName = "of")
public final class FightResponse {
    private Long id;
    private String title;

    public static FightResponse fromFight(Fight fight) {
        return new FightResponse(fight.getId().getValue(), fight.getTitle());
    }
}
