package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class UpdateAnimalCommandHandler implements CommandHandler<UpdateAnimalCommand, Void> {

    private AnimalService animalService;

    public UpdateAnimalCommandHandler(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public Void handle(UpdateAnimalCommand command) {
        animalService.update(command.getId(),command.getName(),command.getType(), command.getStatus(),
                command.getLengthMax(), command.getWeightMax(), command.getSpaceId());
        return null;
    }
}
