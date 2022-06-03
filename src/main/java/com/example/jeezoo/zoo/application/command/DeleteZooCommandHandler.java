package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zoo.domain.ZooService;

public final class DeleteZooCommandHandler implements CommandHandler<DeleteZooCommand, Void> {

    private ZooService zooService;

    public DeleteZooCommandHandler(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public Void handle(DeleteZooCommand command) {
        zooService.deleteZoo(command.id);
        return null;
    }
}
