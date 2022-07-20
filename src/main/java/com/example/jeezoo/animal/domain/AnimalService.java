package com.example.jeezoo.animal.domain;

import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;
import com.example.jeezoo.space.domain.SpaceId;

import java.util.List;

public interface AnimalService {

  AnimalId addAnimal(String name, String type, String status, float lengthMax, float weightMax, String imageLink, Long spaceId);

  Void update(Long id, String name, String type, String status, float lengthMax, float weightMax, String imageLink, Long spaceId);

  void deleteById(Long id);

  ExternalAnimalRequest[] getStarters();

  Long killNumber(List<SpaceId> spaceIdList);
}
