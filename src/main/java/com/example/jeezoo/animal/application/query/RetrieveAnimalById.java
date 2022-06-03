package com.example.jeezoo.animal.application.query;

import com.example.jeezoo.kernel.cqs.Query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class RetrieveAnimalById implements Query {

  public Long id;

}
