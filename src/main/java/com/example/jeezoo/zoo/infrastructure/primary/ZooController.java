package com.example.jeezoo.zoo.infrastructure.primary;

import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.AnimalStatus;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.animal.infrastructure.primary.request.ExternalAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.kernel.exceptions.BadRequestException;
import com.example.jeezoo.space.domain.*;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.domain.UserAnimalService;
import com.example.jeezoo.userAnimal.infrastructure.primary.UserAnimalResponse;
import com.example.jeezoo.zoo.application.command.AddZooCommand;
import com.example.jeezoo.zoo.application.command.DeleteZooCommand;
import com.example.jeezoo.zoo.application.command.UpdateZooCommand;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQuery;
import com.example.jeezoo.zoo.application.query.RetrieveZooById;
import com.example.jeezoo.zoo.domain.*;
import com.example.jeezoo.zoo.infrastructure.primary.request.AddZooRequest;
import com.example.jeezoo.zoo.infrastructure.primary.request.GenerateZooGameRequest;
import com.example.jeezoo.zoo.infrastructure.primary.request.UpdateZooRequest;
import com.example.jeezoo.zoo.infrastructure.primary.response.ZooDetailsResponse;
import com.example.jeezoo.zoo.infrastructure.primary.response.ZooGameDetailsResponse;
import com.example.jeezoo.zoo.infrastructure.primary.response.ZooResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/zoos")
public class ZooController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;
    private final SpaceService spaceService;
    private final Spaces spaces;
    private final ZooService zooService;
    private final AnimalService animalService;
    private final Zoos zoos;
    private final UserAnimalService userAnimalService;
    private final Animals animals;

    public ZooController(
        CommandBus commandBus,
        QueryBus queryBus,
        SpaceService spaceService,
        Spaces spaces,
        ZooService zooService,
        AnimalService animalService,
        Zoos zoos,
        UserAnimalService userAnimalService,
        Animals animals
    ) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.spaceService = spaceService;
        this.spaces = spaces;
        this.zooService = zooService;
        this.animalService = animalService;
        this.zoos = zoos;
        this.userAnimalService = userAnimalService;
        this.animals = animals;
    }

    @PostMapping("")
    public ResponseEntity<Void> addZoo(@RequestBody @Valid AddZooRequest addZooRequest) {
        var addZooCommand = new AddZooCommand(addZooRequest.name(), addZooRequest.zooStatus(), addZooRequest.userId());

        final ZooId zooId = commandBus.send(addZooCommand);

        return ResponseEntity
            .created(linkTo(methodOn(ZooController.class).getZooById(zooId.getValue())).toUri())
            .build();
    }

    @PostMapping("generate")
    public ResponseEntity<GenerateZooGameRequest> generateZooGame(
        @RequestBody @Valid GenerateZooGameRequest generateZooGame
    ) {

        // 1 CREATE ZOO
        ZooId zooId = zooService.addZoo("zoo_1", ZooStatus.IN_PROGRESS, UserId.of(generateZooGame.userId()));

        generateZooGame.spaces().forEach(space -> {

            // 2 CREATE SPACES
            SpaceId spaceId = spaceService.save(Space.createSpace(space.name, SpaceStatus.LOCKED.name(), zooId));

            // 3 CREATE ANIMALS
            String url = "https://zoo-animal-api.herokuapp.com/animals/rand/" + space.animalsNumber;
            RestTemplate restTemplate = new RestTemplate();
            Optional
                .of(restTemplate.getForObject(url, ExternalAnimalRequest[].class))
                .ifPresentOrElse(externalAnimalRequests -> {
                    Arrays.stream(externalAnimalRequests).forEach(externalAnimalRequest -> {
                        animalService.addAnimal(
                            externalAnimalRequest.name,
                            externalAnimalRequest.animal_type,
                            AnimalStatus.Alive.name(),
                            externalAnimalRequest.length_max,
                            externalAnimalRequest.weight_max,
                            externalAnimalRequest.image_link,
                            spaceId.getValue()
                        );
                    });
                }, () -> new BadRequestException(""));
        });

        return ResponseEntity.ok(generateZooGame);
    }

    @GetMapping
    public List<ZooResponse> getAllZoos() {
        List<Zoo> zoos = queryBus.send(new RetrieveAllZoosQuery());
        return zoos.stream().map(ZooResponse::fromZoo).collect(Collectors.toList());
    }

    @GetMapping("/userId/{userId}")
    public List<ZooResponse> getAllZoosByUserId(@PathVariable Long userId) {
        List<Zoo> zoosAllByUserId = zoos.findAllByUserId(UserId.of(userId));
        return zoosAllByUserId.stream().map(ZooResponse::fromZoo).collect(Collectors.toList());
    }

    @GetMapping("/userId/{userId}/details")
    public List<ZooDetailsResponse> getAllZooDetailsByUserId(@PathVariable Long userId) {
        List<Zoo> zoosAllByUserId = zoos.findAllByUserId(UserId.of(userId));
        return zoosAllByUserId.stream().map(zoo -> {
            UserAnimal userAnimal = userAnimalService.findByUserId(zoo.getUserId());
            Long completedSpaceNumber = spaces.countByZooIdAndStatus(zoo.getId(), SpaceStatus.COMPLETED);
            List<SpaceId> spaceIds = spaces.findAllByZooId(zoo.getId()).stream().map(Space::getId).toList();
            Long killNumber = animalService.killNumber(spaceIds);
            return ZooDetailsResponse.fromZoo(
                zoo,
                killNumber,
                completedSpaceNumber,
                UserAnimalResponse.fromUserAnimal(userAnimal)
            );
        }).toList();
    }

    @GetMapping("{zooId}")
    public ResponseEntity<ZooResponse> getZooById(@PathVariable Long zooId) {
        Zoo zoo = queryBus.send(new RetrieveZooById(zooId));
        return ResponseEntity.ok(ZooResponse.fromZoo(zoo));
    }

    @GetMapping("{zooId}/game-details")
    public ResponseEntity<ZooGameDetailsResponse> getZooGameDetailsById(@PathVariable Long zooId) {
        Zoo zoo = queryBus.send(new RetrieveZooById(zooId));
        System.out.println(zoo);
        UserAnimal userAnimal = userAnimalService.findByUserId(zoo.getUserId());
        List<SpaceId> spaceIds = spaces.findAllByZooId(zoo.getId()).stream().map(Space::getId).toList();
        List<AnimalResponse> animalsHistory = animals
            .findAllBySpaceIdInAndStatus(spaceIds, AnimalStatus.Dead)
            .stream()
            .map(AnimalResponse::fromAnimal)
            .toList();
        Long killNumber = animalService.killNumber(spaceIds);

        return ResponseEntity.ok(ZooGameDetailsResponse.from(
            zoo,
            killNumber,
            UserAnimalResponse.fromUserAnimal(userAnimal),
            animalsHistory
        ));
    }

    @PutMapping("{zooId}")
    public ResponseEntity<?> updateZooById(
        @RequestBody @Valid UpdateZooRequest updateZooRequest, @PathVariable Long zooId
    ) {
        var updateZooById = new UpdateZooCommand(
            zooId,
            updateZooRequest.name(),
            updateZooRequest.zooStatus(),
            updateZooRequest.createdAt(),
            updateZooRequest.userId()
        );
        commandBus.send(updateZooById);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{zooId}")
    public ResponseEntity<?> deleteZooById(@PathVariable Long zooId) {
        DeleteZooCommand deleteZooCommand = new DeleteZooCommand(zooId);
        commandBus.send(deleteZooCommand);
        return ResponseEntity.accepted().build();
    }
}