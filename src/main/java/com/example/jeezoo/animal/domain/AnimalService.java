package com.example.jeezoo.animal.domain;

import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;

public interface AnimalService {

  AnimalId addAnimal(String name, String type, String status, float lengthMax, float weightMax, String imageLink, Long spaceId);

  Void update(Long id, String name, String type, String status, float lengthMax, float weightMax, String imageLink, Long spaceId);

  void deleteById(Long id);

  ExternalAnimalRequest[] getStarters();
}
