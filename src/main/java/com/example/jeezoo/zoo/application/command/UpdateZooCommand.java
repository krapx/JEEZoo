package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;

import java.time.LocalDateTime;

public record UpdateZooCommand(
    Long id,
    String name,
    String zooStatus,
    LocalDateTime createdAt,
    Long playerId
) implements Command {
}
