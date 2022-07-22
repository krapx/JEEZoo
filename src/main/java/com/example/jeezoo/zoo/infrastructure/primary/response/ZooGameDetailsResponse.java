package com.example.jeezoo.zoo.infrastructure.primary.response;

import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.playerAnimal.infrastructure.primary.PlayerAnimalResponse;
import com.example.jeezoo.space.exposition.response.SpaceResponse;
import com.example.jeezoo.zoo.domain.Zoo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data(staticConstructor = "of")
public class ZooGameDetailsResponse {

    private final Long id;
    private final String name;
    private final String zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Long playerId;

    private final Long killNumber;
    private final List<PlayerAnimalResponse> playerAnimals;
    private final List<AnimalResponse> animalsHistory;
    private final List<SpaceResponse> spaces;

    public static ZooGameDetailsResponse from(
        Zoo zoo, Long killNumber,
        List<PlayerAnimalResponse> playerAnimalResponseList,
        List<AnimalResponse> animalsHistory,
        List<SpaceResponse> spaces
        ) {
        return new ZooGameDetailsResponse(
            zoo.getId().getValue(),
            zoo.getName(),
            zoo.getZooStatus().name(),
            zoo.getCreatedAt(),
            zoo.getUpdatedAt(),
            zoo.getPlayerId().getValue(),
            killNumber,
            playerAnimalResponseList,
            animalsHistory,
            spaces
        );
    }
}
