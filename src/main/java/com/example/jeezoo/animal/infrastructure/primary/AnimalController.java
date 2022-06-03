package com.example.jeezoo.animal.infrastructure.primary;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.jeezoo.animal.application.command.AddAnimalCommand;
import com.example.jeezoo.animal.application.query.RetrieveAnimalById;
import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.AnimalId;
import com.example.jeezoo.animal.infrastructure.primary.request.AddAnimalRequest;
import com.example.jeezoo.animal.infrastructure.primary.response.AnimalResponse;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("animal")
public class AnimalController {

  private final CommandBus commandBus;
  private final QueryBus   queryBus;

  public AnimalController(CommandBus commandBus, QueryBus queryBus) {
    this.commandBus = commandBus;
    this.queryBus = queryBus;
  }


  @PostMapping("")
  public ResponseEntity<Void> addAnimal(@RequestBody @Valid AddAnimalRequest addAnimalRequest) {
    var addAnimalCommand = new AddAnimalCommand(addAnimalRequest.name, addAnimalRequest.type, addAnimalRequest.status,
                                                addAnimalRequest.arrivalDate, addAnimalRequest.spaceId);

    final AnimalId animalId = commandBus.send(addAnimalCommand);

    return ResponseEntity.created(linkTo(methodOn(AnimalController.class).getAnimalById(animalId.getValue())).toUri())
                         .build();
  }

  @GetMapping("{animalId}")
  public ResponseEntity<?> getAnimalById(@PathVariable Long animalId) {

    Animal animal = queryBus.send(new RetrieveAnimalById(animalId));

    var animalResponse = AnimalResponse.builder()
                                       .id(animal.getId().getValue())
                                       .name(animal.getName())
                                       .type(animal.getType().toString())
                                       .status(animal.getStatus().toString())
                                       .arrivalDate(animal.getArrivalDate())
                                       .build();

    return ResponseEntity.ok(animalResponse);
  }
}
