package com.example.jeezoo.animal.infrastructure.primary.response;

import java.time.LocalDate;

import com.example.jeezoo.animal.domain.Animal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data(staticConstructor = "of")
public class AnimalResponse {

    private final Long id;
    private final String name;
    private final String type;
    private final String status;
    private final float lengthMax;
    private final float weightMax;
    private final LocalDate arrivalDate;
    private final String imageLink;

    public static AnimalResponse fromAnimal(Animal animal) {
        return new AnimalResponse(
            animal.getId().getValue(),
            animal.getName(),
            animal.getType(),
            animal.getStatus().name(),
            animal.getLengthMax(),
            animal.getWeightMax(),
            animal.getArrivalDate(),
            animal.getImageLink()
        );
    }
}
