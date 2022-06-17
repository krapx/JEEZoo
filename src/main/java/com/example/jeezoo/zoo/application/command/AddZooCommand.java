package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class AddZooCommand implements Command {

    private String name;
    private String zooStatus;
}
