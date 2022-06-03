package com.example.jeezoo.fight.domain;

import com.example.jeezoo.fight.domain.exception.FightNotFoundException;

import java.util.List;

public class FightService {
    private final FightRepository fightRepository;

    public FightService(FightRepository fightRepository) {
        this.fightRepository = fightRepository;
    }

    public List<Fight> getAll() {
        return fightRepository.findAll();
    }

    public Fight getById(FightId id) {
        return fightRepository.findById(id).orElseThrow(() -> new FightNotFoundException(id));
    }

    public FightId save(Fight fight) {
        return fightRepository.save(fight);
    }

    public FightId remove(FightId id) {
        return fightRepository.delete(id);
    }
}
