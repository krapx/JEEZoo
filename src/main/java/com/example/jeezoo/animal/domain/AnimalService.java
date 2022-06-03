package com.example.jeezoo.animal.domain;

import java.time.LocalDate;

public interface AnimalService {

  AnimalId addAnimal(String name, String type, String status, LocalDate arrivalDate, Long spaceId);
}
