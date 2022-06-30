package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.kernel.cqs.Command;
import lombok.Data;

@Data
public final class UpdateAnimalCommand implements Command {

    private final Long      id;
    private final String    name;
    private final String    type;
    private final String    status;
    private final float     lengthMax;
    private final float     weightMax;
    private final String    imageLink;
    private final Long      spaceId;

}
