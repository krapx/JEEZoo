package com.example.jeezoo.fight.domain;

import java.util.List;
import java.util.Optional;

public interface FightRepository {
    List<Fight> findAll();
    Optional<Fight> findById(FightId id);
    FightId save(Fight Fight);
    FightId delete(FightId id);
}
