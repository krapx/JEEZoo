package com.example.jeezoo.zoo.infrastructure.primary.response;

import com.example.jeezoo.userAnimal.infrastructure.primary.UserAnimalResponse;
import com.example.jeezoo.zoo.domain.Zoo;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class ZooDetailsResponse {

    private final Long id;
    private final String name;
    private final String zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Long userId;

    private final Long killNumber;
    private final Long completedSpacesNumber;
    private final UserAnimalResponse userAnimal;

    public static ZooDetailsResponse fromZoo(
        Zoo zoo, Long killNumber, Long completedSpacesNumber,
        UserAnimalResponse userAnimalResponse
    ) {
        return new ZooDetailsResponse(
            zoo.getId().getValue(),
            zoo.getName(),
            zoo.getZooStatus().name(),
            zoo.getCreatedAt(),
            zoo.getUpdatedAt(),
            zoo.getUserId().getValue(),
            killNumber,
            completedSpacesNumber,
            userAnimalResponse
        );
    }
}