package com.example.jeezoo.player.domain.model;

import com.example.jeezoo.player.domain.Players;
import com.example.jeezoo.player.domain.model.exception.PlayerUsernameAlreadyExistException;
import com.example.jeezoo.player.domain.model.exception.PlayerUsernameNotFoundException;

public class PlayerService {

    private final Players players;

    public PlayerService(Players players) {
        this.players = players;
    }

    public PlayerId create(Player player) {
        if (players.existsByUsername(player.getUsername())) {
            throw new PlayerUsernameAlreadyExistException(player.getUsername());
        }
        return players.add(player);
    }

    public Player getByUsername(String username) {
        return players.findByUsername(username).orElseThrow(() -> new PlayerUsernameNotFoundException(username));
    }
}
