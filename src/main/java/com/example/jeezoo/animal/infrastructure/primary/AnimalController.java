package com.example.jeezoo.animal.infrastructure.primary;

import com.example.jeezoo.animal.application.command.AddAnimalCommand;
import com.example.jeezoo.animal.application.command.DeleteAnimalCommand;
import com.example.jeezoo.animal.application.command.UpdateAnimalCommand;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimals;
import com.example.jeezoo.animal.application.query.RetrieveAnimalById;
import com.example.jeezoo.animal.domain.*;
import com.example.jeezoo.animal.infrastructure.primary.request.AddAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.request.UpdateAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.Spaces;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final Animals animals;
    private final AnimalService animalService;
    private final Spaces spaces;

    public AnimalController(CommandBus commandBus, QueryBus queryBus, Animals animals, AnimalService animalService,
        Spaces spaces
    ) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.animals = animals;
        this.animalService = animalService;
        this.spaces = spaces;
    }

    @PostMapping("")
    public ResponseEntity<Void> addAnimal(@RequestBody @Valid AddAnimalRequest addAnimalRequest) {
        var addAnimalCommand = new AddAnimalCommand(
            addAnimalRequest.name,
            addAnimalRequest.type,
            addAnimalRequest.status,
            addAnimalRequest.lengthMax,
            addAnimalRequest.weightMax,
            addAnimalRequest.imageLink,
            addAnimalRequest.spaceId
        );

        final AnimalId animalId = commandBus.send(addAnimalCommand);

        return ResponseEntity
            .created(linkTo(methodOn(AnimalController.class).getAnimalById(animalId.getValue())).toUri())
            .build();
    }

    @GetMapping
    public List<AnimalResponse> getAllAnimals() {
        List<Animal> animalsResponse = queryBus.send(new RetrieveAllAnimals());
        return animalsResponse.stream().map(AnimalResponse::fromAnimal).toList();
    }

    @GetMapping("spaceId/{spaceId}")
    public List<AnimalResponse> getAllAnimalsBySpaceId(@PathVariable Long spaceId) {
        List<Animal> animalsResponse = animals.findBySpaceId(SpaceId.of(spaceId));
        return animalsResponse.stream().map(AnimalResponse::fromAnimal).toList();
    }

    @GetMapping("zooId/{zooId}/history")
    public List<AnimalResponse> getAllBySpaceIdInAndStatus(@PathVariable Long zooId) {
        List<Space> zooSpaces = spaces.findAllByZooId(ZooId.of(zooId));
        List<SpaceId> zooSpaceIds = zooSpaces.stream().map(Space::getId).toList();
        List<Animal> animalsResponse = animals.findAllBySpaceIdInAndStatus(zooSpaceIds, AnimalStatus.Dead);
        return animalsResponse.stream().map(AnimalResponse::fromAnimal).toList();
    }

    @GetMapping("{animalId}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long animalId) {
        Animal animal = queryBus.send(new RetrieveAnimalById(animalId));
        return ResponseEntity.ok(AnimalResponse.fromAnimal(animal));
    }

    @GetMapping("starters")
    public ResponseEntity<?> getStarters() {
        ExternalAnimalRequest[] externalAnimalRequest = animalService.getStarters();
        return ResponseEntity.ok(externalAnimalRequest);
    }

    @PutMapping("{animalId}")
    public ResponseEntity<?> updateAnimalById(
        @RequestBody @Valid UpdateAnimalRequest updateAnimalRequest, @PathVariable Long animalId
    ) {
        Animal animal = animalService.getById(animalId);
        var updateAnimalById = new UpdateAnimalCommand(
            animalId,
            updateAnimalRequest.getName(),
            updateAnimalRequest.getType(),
            updateAnimalRequest.getStatus(),
            updateAnimalRequest.getLengthMax(),
            updateAnimalRequest.getWeightMax(),
            updateAnimalRequest.getImageLink(),
            updateAnimalRequest.getSpaceId()
        );
        commandBus.send(updateAnimalById);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("{animalId}/status/{status}")
    public ResponseEntity<?> updateAnimalById(@PathVariable Long animalId, @PathVariable String status) {
        Animal animal = animalService.getById(animalId);
        var updateAnimalById = new UpdateAnimalCommand(
            animalId,
            animal.getName(),
            animal.getType(),
            status,
            animal.getLengthMax(),
            animal.getWeightMax(),
            animal.getImageLink(),
            animal.getSpaceId()
        );
        commandBus.send(updateAnimalById);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("{animalId}")
    public ResponseEntity<?> deleteAnimalById(@PathVariable Long animalId) {
        var deleteAnimalById = new DeleteAnimalCommand(animalId);
        commandBus.send(deleteAnimalById);
        return ResponseEntity.accepted().build();
    }
}
