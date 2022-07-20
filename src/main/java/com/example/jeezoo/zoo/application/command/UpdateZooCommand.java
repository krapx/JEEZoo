package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;

public record UpdateZooCommand(
    Long id,
    String name,
    String zooStatus,
    Long userId
) implements Command {
}
