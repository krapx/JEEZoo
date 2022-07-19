package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.space.domain.SpaceStatus;
import com.example.jeezoo.zoo.domain.ZooId;

public final class UpdateSpaceCmdHandler implements CommandHandler<UpdateSpaceCmd, Void> {

    private final SpaceService spaceService;

    public UpdateSpaceCmdHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public Void handle(UpdateSpaceCmd command) {
        spaceService.save(Space.of(
            new SpaceId(command.id),
            command.name,
            SpaceStatus.valueOf(command.status),
            ZooId.of(command.zooId)
        ));
        return null;
    }
}
