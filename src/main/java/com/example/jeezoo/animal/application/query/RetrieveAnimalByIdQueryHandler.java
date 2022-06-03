package com.example.jeezoo.animal.application.query;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.kernel.cqs.QueryHandler;
import javax.persistence.EntityNotFoundException;

public final class RetrieveAnimalByIdQueryHandler implements QueryHandler<RetrieveAnimalById, Animal> {

  private final Animals animals;

  public RetrieveAnimalByIdQueryHandler(Animals animals) {
    this.animals = animals;
  }

  @Override
  public Animal handle(RetrieveAnimalById query) {
    AnimalId animalId = AnimalId.of(query.id);

    return animals.findById(animalId)
                  .orElseThrow(() -> new EntityNotFoundException("no Animal found for ID :" + query.id));

  }
}
