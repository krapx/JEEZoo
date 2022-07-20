package com.example.jeezoo.userAnimal.domain;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.exception.UserAnimalNotFoundException;
import com.example.jeezoo.zoo.domain.ZooService;
import org.springframework.stereotype.Component;

@Component
public class UserAnimalService {

    private final UserAnimals userAnimals;
    private final ZooService zooService;

    public UserAnimalService(UserAnimals userAnimals, ZooService zooService) {
        this.userAnimals = userAnimals;
        this.zooService = zooService;
    }

    public UserAnimal findByUserId(UserId userId) {
        // Validation UserId
        return userAnimals.findByUserId(userId).orElseThrow(() -> new UserAnimalNotFoundException(userId));
    }

    public UserAnimal findById(UserAnimalId userAnimalId) {
        return userAnimals.findById(userAnimalId).orElseThrow(() -> new UserAnimalNotFoundException(userAnimalId));
    }

    public UserAnimalId create(UserAnimal userAnimal) {
        return userAnimals.save(userAnimal);
    }

    public UserAnimalId update(UserAnimal userAnimal) {
        findById(userAnimal.getId());
        zooService.getZooById(userAnimal.getZooId());
        return userAnimals.save(userAnimal);
    }
}
