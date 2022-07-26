package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.space.domain.SpaceStatus;

public final class UpdateAnimalCommandHandler implements CommandHandler<UpdateAnimalCommand, Void> {

    private final AnimalService animalService;
    private final Animals animals;
    private final SpaceService spaceService;

    public UpdateAnimalCommandHandler(AnimalService animalService, Animals animals, SpaceService spaceService) {
        this.animalService = animalService;
        this.animals = animals;
        this.spaceService = spaceService;
    }

    @Override
    public Void handle(UpdateAnimalCommand command) {
        animalService.update(
            command.getId(),
            command.getName(),
            command.getType(),
            command.getStatus(),
            command.getLengthMax(),
            command.getWeightMax(),
            command.getImageLink(),
            command.getSpaceId()
        );

        boolean isSpaceCompleted = !animals.existsBySpaceIdAndStatus(
            SpaceId.of(command.getSpaceId()),
            AnimalStatus.Alive
        );

        // TODO
        boolean zooHasInProgressSpace = false;

        if (isSpaceCompleted && zooHasInProgressSpace) {
            spaceService.saveStatus(SpaceId.of(command.getSpaceId()), SpaceStatus.COMPLETED);
            Space nextSpaceToUnlock = spaceService.getNextByZooIdAndStatus(
                spaceService.getById(SpaceId.of(command.getSpaceId())).getZooId(),
                SpaceStatus.LOCKED
            );
            spaceService.saveStatus(nextSpaceToUnlock.getId(), SpaceStatus.IN_PROGRESS);
        }

        return null;
    }
}
