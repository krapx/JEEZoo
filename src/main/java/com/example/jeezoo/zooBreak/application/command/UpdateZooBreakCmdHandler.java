package com.example.jeezoo.zooBreak.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zooBreak.application.command.UpdateZooBreakCmd;
import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;

public final class UpdateZooBreakCmdHandler implements CommandHandler<UpdateZooBreakCmd, Void> {

    private ZooBreakService zooBreakService;

    public UpdateZooBreakCmdHandler(ZooBreakService zooBreakService) {
        this.zooBreakService = zooBreakService;
    }

    @Override
    public Void handle(UpdateZooBreakCmd command) {
        zooBreakService.save(ZooBreak.of(
            new ZooBreakId(command.id),
            command.title
        ));
        return null;
    }
}
