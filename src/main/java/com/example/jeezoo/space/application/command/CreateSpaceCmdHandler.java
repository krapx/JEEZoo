package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.zoo.domain.ZooId;

public final class CreateSpaceCmdHandler implements CommandHandler<CreateSpaceCmd, Long> {

    private final SpaceService spaceService;

    public CreateSpaceCmdHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public Long handle(CreateSpaceCmd command) {
        return spaceService.save(Space.createSpace(
            command.name,
            command.status,
            ZooId.of(command.zooId))
        ).getValue();
    }
}
