package com.example.jeezoo.animal.infrastructure.primary.request;

import java.time.LocalDate;

public class AddAnimalRequest {

  public Long      animalTransactionId;
  public String    name;
  public String    type;
  public String    status;
  public LocalDate arrivalDate;
  public Long      spaceId;
}
