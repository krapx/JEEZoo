package com.example.jeezoo.animal.application;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import org.apache.tomcat.jni.Local;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class DefaultAnimalService implements AnimalService {

  private final Animals animals;

  public DefaultAnimalService(Animals animals) {
    this.animals = animals;
  }

  @Override
  public AnimalId addAnimal(String name, String type, String status,
                            float lengthMax, float weightMax, String imageLink, Long spaceId) {
    final AnimalId animalId = AnimalId.noId();
//    final Animal animal = Animal.of(animalId, name, type, status, LocalDate.now(), spaceId);
    final Animal animal = Animal.createAnimal(name, type, status, lengthMax, weightMax,
            LocalDate.now(), imageLink, spaceId);
    return animals.save(animal);
  }

  @Override
  public Void update(Long id, String name, String type, String status,
                     float lengthMax, float weightMax, String imageLink, Long spaceId) {
    final Animal animal = Animal.of(AnimalId.of(id),name, type, status,
            lengthMax, weightMax, LocalDate.now(),imageLink, spaceId);
    animals.save(animal);
    return null;
  }

  @Override
  public void deleteById(Long id) {
    final AnimalId animalId = AnimalId.of(id);
    animals.deleteById(animalId);
  }

  @Override
  public ExternalAnimalRequest[] getStarters(){
    String url = "https://zoo-animal-api.herokuapp.com/animals/rand/3";
    RestTemplate restTemplate = new RestTemplate();
    ExternalAnimalRequest[] externalAnimalRequests = restTemplate
            .getForObject(url, ExternalAnimalRequest[].class);
    return externalAnimalRequests;
  }
}