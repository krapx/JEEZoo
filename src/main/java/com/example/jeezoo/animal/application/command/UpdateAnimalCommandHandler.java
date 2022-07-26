package com.example.jeezoo.animal.application.command;

import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.space.domain.*;
import com.example.jeezoo.zoo.domain.ZooId;

public final class UpdateAnimalCommandHandler implements CommandHandler<UpdateAnimalCommand, Void> {

    private final AnimalService animalService;
    private final Animals animals;
    private final SpaceService spaceService;
    private final Spaces spaces;

    public UpdateAnimalCommandHandler(
        AnimalService animalService, Animals animals, SpaceService spaceService,
        Spaces spaces
    ) {
        this.animalService = animalService;
        this.animals = animals;
        this.spaceService = spaceService;
        this.spaces = spaces;
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

        Space spaceOfAnimal = spaceService.getById(SpaceId.of(command.getSpaceId()));

        boolean isSpaceCompleted = !animals.existsBySpaceIdAndStatus(
            SpaceId.of(command.getSpaceId()),
            AnimalStatus.Alive
        );

        boolean zooHasInProgressSpace = spaces.existsByZooIdAndStatus(
            spaceOfAnimal.getZooId(),
            SpaceStatus.IN_PROGRESS
        );

        if (isSpaceCompleted) {
            spaceService.saveStatus(SpaceId.of(command.getSpaceId()), SpaceStatus.COMPLETED);
            if (!zooHasInProgressSpace) {
                Space nextSpaceToUnlock = spaceService.getNextByZooIdAndStatus(
                    spaceOfAnimal.getZooId(),
                    SpaceStatus.LOCKED
                );
                spaceService.saveStatus(nextSpaceToUnlock.getId(), SpaceStatus.IN_PROGRESS);
            }
        }

        return null;
    }
}
