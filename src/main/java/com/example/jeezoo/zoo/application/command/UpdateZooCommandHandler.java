package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zoo.domain.ZooService;

public final class UpdateZooCommandHandler implements CommandHandler<UpdateZooCommand, Void> {

    private ZooService zooService;

    public UpdateZooCommandHandler(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public Void handle(UpdateZooCommand command) {
        zooService.update(command.getId(), command.getName(), command.getZooStatus());
        return null;
    }
}
