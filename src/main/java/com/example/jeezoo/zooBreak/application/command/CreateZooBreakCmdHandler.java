package com.example.jeezoo.zooBreak.application.command;

import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.zooBreak.application.command.CreateZooBreakCmd;
import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;

public final class CreateZooBreakCmdHandler implements CommandHandler<CreateZooBreakCmd, Long> {

    private final ZooBreakService zooBreakService;

    public CreateZooBreakCmdHandler(ZooBreakService zooBreakService) {
        this.zooBreakService = zooBreakService;
    }

    @Override
    public Long handle(CreateZooBreakCmd command) {
        return zooBreakService.save(ZooBreak.createZooBreak(command.title)).getValue();
    }
}
