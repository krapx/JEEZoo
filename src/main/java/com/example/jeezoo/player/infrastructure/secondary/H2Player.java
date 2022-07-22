package com.example.jeezoo.player.infrastructure.secondary;

import com.example.jeezoo.player.domain.Players;
import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static java.lang.String.format;

@Repository
public class H2Player implements Players {

    private final Logger logger = Logger.getLogger(H2Player.class.getName());
    private final JpaPlayer jpaPlayer;
    private final PlayerAdapter playerAdapter;

    public H2Player(JpaPlayer jpaPlayer, PlayerAdapter playerAdapter) {
        this.jpaPlayer = jpaPlayer;
        this.playerAdapter = playerAdapter;
    }

    @Override
    public PlayerId add(Player player) {
        var playerEntity = jpaPlayer.save(playerAdapter.toEntity(player));
        var playerSaved = playerAdapter.toModel(playerEntity);
        return playerSaved.getId();
    }

    @Override
    public Player update(Player player) {
        return null;
    }

    @Override
    public List<Player> findAll() {
        return jpaPlayer.findAll().stream().map(playerAdapter::toModel).toList();
    }

    @Override
    public Player findById(PlayerId playerId) {
        Optional<Player> player = jpaPlayer.findById(playerId.getValue()).map(playerAdapter::toModel);
        if (player.isPresent())
            return player.get();
        else
            throw new NoResultException("Player not found, id = " + playerId.getValue());
    }

    @Override
    public Optional<Player> findByUsername(String username) {
        Optional<Player> user = jpaPlayer.findByUsername(username).map(playerAdapter::toModel);
        if (user.isPresent())
            return user;
        else
            throw new NoResultException("User not found, username = " + user);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return jpaPlayer.existsByUsername(username);
    }
}
