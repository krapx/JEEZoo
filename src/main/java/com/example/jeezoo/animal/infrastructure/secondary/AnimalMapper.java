package com.example.jeezoo.animal.infrastructure.secondary;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import com.example.jeezoo.kernel.Adapter;
import org.springframework.stereotype.Component;

@Component
public final class AnimalMapper implements Adapter<AnimalEntity, Animal> {

  @Override
  public Animal adapt(AnimalEntity source) {
    return Animal.of(new AnimalId(source.getId()), source.getName(), source.getType(), source.getStatus(),
                     source.getArrivalDate(), source.getSpaceId());
  }
}
