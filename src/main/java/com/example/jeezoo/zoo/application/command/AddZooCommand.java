package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddZooCommand implements Command {

    private String name;
    private String location;
    private Float size;
    private String spaceCapacity;
    private String peopleCapacity;
    private String zooStatus;
}
