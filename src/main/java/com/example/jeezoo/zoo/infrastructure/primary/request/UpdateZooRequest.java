package com.example.jeezoo.zoo.infrastructure.primary.request;

public record UpdateZooRequest(
    String name,
    String zooStatus,
    Long userId
) {
}
