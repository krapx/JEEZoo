package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;

@Data
public final class UpdateZooCommand implements Command {

    private final Long id;
    private final String name;
    private final String zooStatus;
}
