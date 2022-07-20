package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.kernel.annotations.Service;
import com.example.jeezoo.userAnimal.domain.UserAnimalService;
import com.example.jeezoo.userAnimal.domain.UserAnimals;
import com.example.jeezoo.zoo.domain.ZooService;

@Service
public class SpringUserAnimalService extends UserAnimalService {

    public SpringUserAnimalService(UserAnimals userAnimals, ZooService zooService) {
        super(userAnimals, zooService);
    }
}
