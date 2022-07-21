package com.example.jeezoo.player.infrastructure.primary;

import com.example.jeezoo.player.domain.model.Player;

import java.time.LocalDateTime;

public record PlayerResponse(
    Long id,
    String username,
    String mail,
    String role,
    LocalDateTime creationAt,
    LocalDateTime updatedAt
) {
    public static PlayerResponse fromPlayer(Player player) {
        return new PlayerResponse(
            player.getId().getValue(),
            player.getUsername(),
            player.getMail(),
            player.getPlayerRole().name(),
            player.getCreationAt(),
            player.getUpdatedAt()
        );
    }
}