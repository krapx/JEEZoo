package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;

public record AddZooCommand(
    String name,
    String zooStatus,
    Long playerId
) implements Command {
}
