package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooService;
import com.example.jeezoo.zoo.domain.ZooStatus;

public final class UpdateZooCommandHandler implements CommandHandler<UpdateZooCommand, Void> {

    private final ZooService zooService;

    public UpdateZooCommandHandler(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public Void handle(UpdateZooCommand command) {
        zooService.update(
            ZooId.of(command.id()),
            command.name(),
            ZooStatus.valueOf(command.zooStatus()),
            UserId.of(command.userId())
        );
        return null;
    }
}
