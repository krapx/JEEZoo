package com.example.jeezoo.fight.application.command;

import com.example.jeezoo.fight.application.command.UpdateFightCmd;
import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightId;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class UpdateFightCmdHandler implements CommandHandler<UpdateFightCmd, Void> {

    private FightService fightService;

    public UpdateFightCmdHandler(FightService fightService) {
        this.fightService = fightService;
    }

    @Override
    public Void handle(UpdateFightCmd command) {
        fightService.save(Fight.of(
            new FightId(command.id),
            command.title
        ));
        return null;
    }
}
