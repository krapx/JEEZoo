package com.example.jeezoo.zoo.infrastructure.primary.request;

public record AddZooRequest(
    String name,
    String zooStatus,
    Long playerId
) {
}