package com.example.jeezoo.animal.infrastructure.primary;

import com.example.jeezoo.animal.application.command.AddAnimalCommand;
import com.example.jeezoo.animal.application.command.DeleteAnimalCommand;
import com.example.jeezoo.animal.application.command.UpdateAnimalCommand;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimals;
import com.example.jeezoo.animal.application.query.RetrieveAnimalById;
import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.primary.request.AddAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.request.UpdateAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.space.domain.SpaceId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final Animals animals;
    private final AnimalService animalService;

    public AnimalController(CommandBus commandBus, QueryBus queryBus, Animals animals, AnimalService animalService) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.animals = animals;
        this.animalService = animalService;
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

    @GetMapping("spaceId/{id}")
    public List<AnimalResponse> getAllAnimalsBySpaceId(@PathVariable Long id) {
        List<Animal> animalsResponse = animals.findBySpaceId(SpaceId.of(id));
        return animalsResponse.stream().map(AnimalResponse::fromAnimal).toList();
    }

    @GetMapping("{animalId}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long animalId) {
        Animal animal = queryBus.send(new RetrieveAnimalById(animalId));
        return ResponseEntity.ok(AnimalResponse.fromAnimal(animal));
    }

    @GetMapping("starters")
    public ResponseEntity<?> getStarters(){
        ExternalAnimalRequest[] externalAnimalRequest = animalService.getStarters();
        return ResponseEntity.ok(externalAnimalRequest);
    }

    @PutMapping("{animalId}")
    public ResponseEntity<?> updateAnimalById(
        @RequestBody @Valid UpdateAnimalRequest updateAnimalRequest, @PathVariable Long animalId
    ) {
        var updateAnimalById = new UpdateAnimalCommand(animalId, updateAnimalRequest.name, updateAnimalRequest.type,
                                                       updateAnimalRequest.status, updateAnimalRequest.lengthMax,
                                                        updateAnimalRequest.weightMax, updateAnimalRequest.imageLink,
                                                        updateAnimalRequest.spaceId
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
