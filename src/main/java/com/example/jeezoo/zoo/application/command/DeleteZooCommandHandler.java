package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooService;

public final class DeleteZooCommandHandler implements CommandHandler<DeleteZooCommand, Void> {

    private final ZooService zooService;

    public DeleteZooCommandHandler(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public Void handle(DeleteZooCommand command) {
        zooService.deleteZoo(ZooId.of(command.id));
        return null;
    }
}
