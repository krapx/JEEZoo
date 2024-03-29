package com.example.jeezoo.zoo.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooService;
import com.example.jeezoo.zoo.domain.ZooStatus;

public final class AddZooCommandHandler implements CommandHandler<AddZooCommand, ZooId> {

    private final ZooService zooService;

    public AddZooCommandHandler(ZooService zooService) {
        this.zooService = zooService;
    }

    @Override
    public ZooId handle(AddZooCommand command) {
        return zooService.addZoo(
            command.name(),
            ZooStatus.valueOf(command.zooStatus()),
            PlayerId.of(command.playerId())
        );
    }
}
