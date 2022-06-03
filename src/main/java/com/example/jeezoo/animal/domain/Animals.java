package com.example.jeezoo.animal.domain;

import java.util.List;
import java.util.Optional;

public interface Animals {

  AnimalId save(Animal animal);

  Optional<Animal> findById(AnimalId animalId);

  List<Animal> findAll();

  void deleteById(AnimalId animalId);
}
