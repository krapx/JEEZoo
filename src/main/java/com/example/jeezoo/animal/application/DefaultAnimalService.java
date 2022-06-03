package com.example.jeezoo.animal.application;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import java.time.LocalDate;

public final class DefaultAnimalService implements AnimalService {

  private final Animals animals;

  public DefaultAnimalService(Animals animals) {
    this.animals = animals;
  }

  @Override
  public AnimalId addAnimal(String name, String type, String status, LocalDate arrivalDate, Long spaceId) {
    final AnimalId animalId = AnimalId.noId();
    final Animal animal = Animal.of(animalId, name, type, status, arrivalDate, spaceId);
    //final Animal animal = Animal.createAnimal(name, type, status, arrivalDate, spaceId);
    return animals.save(animal);
  }
}
