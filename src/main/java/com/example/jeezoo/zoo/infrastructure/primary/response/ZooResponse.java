package com.example.jeezoo.zoo.infrastructure.primary.response;

import com.example.jeezoo.zoo.domain.Zoo;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class ZooResponse {
    private final Long id;
    private final String name;
    private final String zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Long playerId;

    public static ZooResponse fromZoo(Zoo zoo) {
        return new ZooResponse(
            zoo.getId().getValue(),
            zoo.getName(),
            zoo.getZooStatus().name(),
            zoo.getCreatedAt(),
            zoo.getUpdatedAt(),
            zoo.getPlayerId().getValue()
        );
    }
}
