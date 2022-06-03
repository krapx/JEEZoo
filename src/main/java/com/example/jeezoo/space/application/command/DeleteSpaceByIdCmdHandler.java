package com.example.jeezoo.space.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;

public final class DeleteSpaceByIdCmdHandler implements CommandHandler<DeleteSpaceByIdCmd, Void> {

    private SpaceService spaceService;

    public DeleteSpaceByIdCmdHandler(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @Override
    public Void handle(DeleteSpaceByIdCmd command) {
        spaceService.remove(new SpaceId(command.getId()));
        return null;
    }
}
