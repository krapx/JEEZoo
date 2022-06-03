package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class DeleteAnimalCommandHandler implements CommandHandler<DeleteAnimalCommand, Void> {

    private AnimalService animalService;

    public DeleteAnimalCommandHandler(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public Void handle(DeleteAnimalCommand command) {
        animalService.deleteById(command.id);
        return null;
    }
}
