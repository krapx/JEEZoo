package com.example.jeezoo.player.infrastructure.secondary;

import com.example.jeezoo.player.domain.model.Player;
import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.player.domain.model.PlayerRole;
import org.springframework.stereotype.Component;

@Component
public class PlayerAdapter {

    public Player toModel(PlayerEntity playerEntity) {
        return Player.of(
            PlayerId.of(playerEntity.getId()),
            playerEntity.getUsername(),
            playerEntity.getPassword(),
            playerEntity.getMail(),
            PlayerRole.valueOf(playerEntity.getRole()),
            playerEntity.getCreationAt(),
            playerEntity.getUpdatedAt()
        );
    }

    public PlayerEntity toEntity(Player player) {
        return new PlayerEntity(
            player.getId().getValue(),
            player.getUsername(),
            player.getPassword(),
            player.getMail(),
            player.getPlayerRole().name(),
            player.getCreationAt(),
            player.getUpdatedAt()
        );
    }
}
