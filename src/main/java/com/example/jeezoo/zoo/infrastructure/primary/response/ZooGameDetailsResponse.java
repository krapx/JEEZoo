package com.example.jeezoo.zoo.infrastructure.primary.response;

import com.example.jeezoo.userAnimal.infrastructure.primary.UserAnimalResponse;
import com.example.jeezoo.zoo.domain.Zoo;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class ZooGameDetailsResponse {

    private final Long id;
    private final String name;
    private final String zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Long userId;

    private final Long killNumber;
    private final UserAnimalResponse userAnimal;

    public static ZooGameDetailsResponse from(
        Zoo zoo, Long killNumber,
        UserAnimalResponse userAnimalResponse
    ) {
        return new ZooGameDetailsResponse(
            zoo.getId().getValue(),
            zoo.getName(),
            zoo.getZooStatus().name(),
            zoo.getCreatedAt(),
            zoo.getUpdatedAt(),
            zoo.getUserId().getValue(),
            killNumber,
            userAnimalResponse
        );
    }
}
