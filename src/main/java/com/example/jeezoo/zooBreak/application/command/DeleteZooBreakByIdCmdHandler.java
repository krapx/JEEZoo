package com.example.jeezoo.zooBreak.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zooBreak.application.command.DeleteZooBreakByIdCmd;
import com.example.jeezoo.zooBreak.domain.ZooBreakId;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;

public final class DeleteZooBreakByIdCmdHandler implements CommandHandler<DeleteZooBreakByIdCmd, Void> {

    private ZooBreakService zooBreakService;

    public DeleteZooBreakByIdCmdHandler(ZooBreakService zooBreakService) {
        this.zooBreakService = zooBreakService;
    }

    @Override
    public Void handle(DeleteZooBreakByIdCmd command) {
        zooBreakService.remove(new ZooBreakId(command.getId()));
        return null;
    }
}
