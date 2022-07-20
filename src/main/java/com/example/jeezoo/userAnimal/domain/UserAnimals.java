package com.example.jeezoo.userAnimal.domain;

import com.example.jeezoo.user.domain.model.UserId;

import java.util.List;
import java.util.Optional;

public interface UserAnimals {
    List<UserAnimal> findAll();
    Optional<UserAnimal> findById(UserAnimalId userAnimalId);
    Optional<UserAnimal> findByUserId(UserId userId);
    UserAnimalId save(UserAnimal userAnimal);
}