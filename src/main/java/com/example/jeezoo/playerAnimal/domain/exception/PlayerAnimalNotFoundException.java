package com.example.jeezoo.playerAnimal.domain.exception;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimalId;

public class PlayerAnimalNotFoundException extends RuntimeException {

    public PlayerAnimalNotFoundException(PlayerAnimalId playerAnimalId) {
        super("PlayerAnimal with id \"" + playerAnimalId.getValue() + "\" not found");
    }
    public PlayerAnimalNotFoundException(PlayerId playerId) {
        super("PlayerAnimal with PlayerId.id \"" + playerId.getValue() + "\" not found");
    }
}
