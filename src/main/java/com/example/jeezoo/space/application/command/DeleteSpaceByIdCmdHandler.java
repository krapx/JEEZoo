package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;

public final class DeleteSpaceByIdCmdHandler implements CommandHandler<DeleteSpaceByIdCmd, Void> {

    private final SpaceService spaceService;

    public DeleteSpaceByIdCmdHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public Void handle(DeleteSpaceByIdCmd command) {
        spaceService.remove(SpaceId.of(command.getId()));
        return null;
    }
}
