package com.example.jeezoo.fight.application;

import com.example.jeezoo.fight.domain.FightRepository;
import com.example.jeezoo.fight.domain.FightService;
import org.springframework.stereotype.Service;

@Service
public class SpringFightService extends FightService {
    public SpringFightService(FightRepository fightRepository) {
        super(fightRepository);
    }
}
