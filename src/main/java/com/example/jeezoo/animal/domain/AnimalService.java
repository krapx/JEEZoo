package com.example.jeezoo.animal.domain;

public interface AnimalService {

  AnimalId addAnimal(String name, String type, String status, float lengthMax, float weightMax, Long spaceId);

  Void update(Long id, String name, String type, String status, float lengthMax, float weightMax, Long spaceId);

  void deleteById(Long id);
}
