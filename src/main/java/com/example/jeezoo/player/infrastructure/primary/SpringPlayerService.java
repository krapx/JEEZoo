package com.example.jeezoo.player.infrastructure.primary;

import com.example.jeezoo.player.domain.Players;
import com.example.jeezoo.player.domain.model.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class SpringPlayerService extends PlayerService {

    public SpringPlayerService(Players players) {
        super(players);
    }
}
