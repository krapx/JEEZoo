package com.example.jeezoo.player.domain;


import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

  PlayerId add(Player player);

  Player update(Player player);

  List<Player> findAll();

  Player findById(PlayerId playerId);

  Optional<Player> findByUsername(String username);
}
