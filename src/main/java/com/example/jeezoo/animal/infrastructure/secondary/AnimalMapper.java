package com.example.jeezoo.animal.infrastructure.secondary;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.infrastructure.secondary.jpa.entity.AnimalEntity;
import com.example.jeezoo.kernel.Adapter;
import org.springframework.stereotype.Component;

@Component
public final class AnimalMapper implements Adapter<AnimalEntity, Animal> {

    @Override
    public Animal adapt(AnimalEntity source) {
        return Animal.of(new AnimalId(source.getId()),
            source.getName(),
            source.getType(),
            AnimalStatus.valueOf(source.getStatus()),
            source.getLengthMax(),
            source.getWeightMax(),
            source.getArrivalDate(),
            source.getImageLink(),
            source.getSpaceId()
        );
    }
}
