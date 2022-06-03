package com.example.jeezoo.animal.infrastructure.secondary;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import com.example.jeezoo.kernel.Adapter;
import org.springframework.stereotype.Component;

@Component
public final class AnimalAdapter implements Adapter<Animal, AnimalEntity> {

  @Override
  public AnimalEntity adapt(Animal source) {
    return new AnimalEntity(source.getId().getValue(), source.getName(), source.getType().name(),
                            source.getStatus().name(), source.getArrivalDate(), source.getSpaceId());
  }
}
