package com.example.jeezoo.animal.application;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;

public final class DefaultAnimalService implements AnimalService {

  private final Animals animals;

  public DefaultAnimalService(Animals animals) {
    this.animals = animals;
  }

  @Override
  public AnimalId addAnimal(String name, String type, String status, Long spaceId) {
    final AnimalId animalId = AnimalId.noId();
//    final Animal animal = Animal.of(animalId, name, type, status, LocalDate.now(), spaceId);
    final Animal animal = Animal.createAnimal(name, type, status, LocalDate.now(), spaceId);
    return animals.save(animal);
  }

  @Override
  public Void update(Long id, String name, String type, String status, Long spaceId) {
    final Animal animal = Animal.of(AnimalId.of(id),name, type, status, LocalDate.now(), spaceId);
    animals.save(animal);
    return null;
  }

  @Override
  public void deleteById(Long id) {
    final AnimalId animalId = AnimalId.of(id);
    animals.deleteById(animalId);
  }
}
