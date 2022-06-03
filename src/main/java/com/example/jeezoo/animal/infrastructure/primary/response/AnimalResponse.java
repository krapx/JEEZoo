package com.example.jeezoo.animal.infrastructure.primary.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class AnimalResponse {

  public Long      id;
  public String    name;
  public String    status;
  public String    type;
  public LocalDate arrivalDate;

}
