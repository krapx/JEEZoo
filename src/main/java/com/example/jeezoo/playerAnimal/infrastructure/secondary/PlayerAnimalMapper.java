package com.example.jeezoo.playerAnimal.infrastructure.secondary;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimal;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimalDamage;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimalId;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.stereotype.Component;

@Component
public class PlayerAnimalMapper {

    public PlayerAnimal toModel(PlayerAnimalEntity playerAnimalEntity) {
        return PlayerAnimal.of(
            PlayerAnimalId.of(playerAnimalEntity.getId()),
            PlayerAnimalDamage.of(playerAnimalEntity.getDamage()),
            playerAnimalEntity.getName(),
            playerAnimalEntity.getImage(),
            playerAnimalEntity.getCreationAt(),
            playerAnimalEntity.getUpdatedAt(),
            PlayerId.of(playerAnimalEntity.getPlayerId()),
            ZooId.of(playerAnimalEntity.getZooId())
        );
    }

    public PlayerAnimalEntity toEntity(PlayerAnimal playerAnimal) {
        return new PlayerAnimalEntity(
            playerAnimal.getId().getValue(),
            playerAnimal.getDamage().getValue(),
            playerAnimal.getName(),
            playerAnimal.getImage(),
            playerAnimal.getCreationAt(),
            playerAnimal.getUpdatedAt(),
            playerAnimal.getPlayerId().getValue(),
            playerAnimal.getZooId().getValue()
        );
    }
}
