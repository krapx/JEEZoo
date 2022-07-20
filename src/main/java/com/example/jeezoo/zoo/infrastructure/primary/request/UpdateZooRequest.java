package com.example.jeezoo.zoo.infrastructure.primary.request;

import java.time.LocalDateTime;

public record UpdateZooRequest(
    String name,
    String zooStatus,
    LocalDateTime createdAt,
    Long playerId
) {
}
