package com.example.jeezoo.animal.domain;

public interface AnimalService {

  AnimalId addAnimal(String name, String type, String status, Long spaceId);

  Void update(Long id, String name, String type, String status, Long spaceId);

  void deleteById(Long id);
}
