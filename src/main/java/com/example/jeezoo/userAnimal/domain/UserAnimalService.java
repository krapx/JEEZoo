package com.example.jeezoo.userAnimal.domain;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.exception.UserAnimalBadArgumentException;
import com.example.jeezoo.userAnimal.domain.exception.UserAnimalNotFoundException;

import java.util.Objects;

public class UserAnimalService {

    private final UserAnimals userAnimals;

    public UserAnimalService(UserAnimals userAnimals) {
        this.userAnimals = userAnimals;
    }

    public UserAnimal findByUserId(UserId userId) {
        // Validation UserId
        return userAnimals.findByUserId(userId).orElseThrow(() -> new UserAnimalNotFoundException(userId));
    }

    public UserAnimalId create(UserAnimal userAnimal) {
        if (Objects.equals(userAnimal.getId(), -1L)) throw new UserAnimalBadArgumentException();
        // Validation UserId
        return userAnimals.save(userAnimal);
    }

    public UserAnimalId update(UserAnimal userAnimal) {
        userAnimals.findById(userAnimal.getId()).orElseThrow(() -> new UserAnimalNotFoundException(userAnimal.getId()));
        // Validation UserId
        return userAnimals.save(userAnimal);
    }
}
