package com.example.jeezoo.playerAnimal.infrastructure.primary;

import com.example.jeezoo.kernel.annotations.Service;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimalService;
import com.example.jeezoo.playerAnimal.domain.PlayerAnimals;
import com.example.jeezoo.zoo.domain.ZooService;

@Service
public class SpringPlayerAnimalService extends PlayerAnimalService {

    public SpringPlayerAnimalService(PlayerAnimals playerAnimals, ZooService zooService) {
        super(playerAnimals, zooService);
    }
}
