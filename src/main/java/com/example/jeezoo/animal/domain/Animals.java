package com.example.jeezoo.animal.domain;

import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.zoo.domain.ZooId;

import java.util.List;
import java.util.Optional;

public interface Animals {

  AnimalId save(Animal animal);

  Optional<Animal> findById(AnimalId animalId);

  List<Animal> findAll();

  void deleteById(AnimalId animalId);
  List<Animal> findBySpaceId(SpaceId spaceId);

  Long countBySpaceIdInAndStatus(List<SpaceId> spaceIdList, AnimalStatus status);
}
