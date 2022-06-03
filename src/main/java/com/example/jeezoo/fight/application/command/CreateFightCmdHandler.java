package com.example.jeezoo.fight.application.command;

import com.example.jeezoo.fight.application.command.CreateFightCmd;
import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class CreateFightCmdHandler implements CommandHandler<CreateFightCmd, Long> {

    private final FightService fightService;

    public CreateFightCmdHandler(FightService fightService) {
        this.fightService = fightService;
    }

    @Override
    public Long handle(CreateFightCmd command) {
        return fightService.save(Fight.createFight(command.title)).getValue();
    }
}
