package com.example.jeezoo.fight.application.command;

import com.example.jeezoo.fight.application.command.DeleteFightByIdCmd;
import com.example.jeezoo.fight.domain.FightId;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class DeleteFightByIdCmdHandler implements CommandHandler<DeleteFightByIdCmd, Void> {

    private FightService fightService;

    public DeleteFightByIdCmdHandler(FightService fightService) {
        this.fightService = fightService;
    }

    @Override
    public Void handle(DeleteFightByIdCmd command) {
        fightService.remove(new FightId(command.getId()));
        return null;
    }
}
