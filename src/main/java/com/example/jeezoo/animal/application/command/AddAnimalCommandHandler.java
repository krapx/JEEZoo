package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.kernel.cqs.CommandHandler;

public final class AddAnimalCommandHandler implements CommandHandler<AddAnimalCommand, AnimalId> {

  private final AnimalService animalService;

  public AddAnimalCommandHandler(AnimalService animalService) {
    this.animalService = animalService;
  }

  @Override
  public AnimalId handle(AddAnimalCommand command) {

    return animalService.addAnimal(command.getName(), command.getType(), command.getStatus(),
            command.getLengthMax(), command.getWeightMax(), command.getImageLink(), command.getSpaceId());
  }
}
