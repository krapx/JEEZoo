package com.example.jeezoo.zoo.infrastructure.primary;

import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.zoo.application.command.AddZooCommand;
import com.example.jeezoo.zoo.application.query.RetrieveZooById;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.infrastructure.primary.request.AddZooRequest;
import com.example.jeezoo.zoo.infrastructure.primary.response.ZooResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("zoo")
public class ZooController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ZooController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping("")
    public ResponseEntity<Void> addZoo(@RequestBody @Valid AddZooRequest addZooRequest) {
        var addZooCommand = new AddZooCommand(addZooRequest.name, addZooRequest.location, addZooRequest.size,
                addZooRequest.spaceCapacity, addZooRequest.peopleCapacity, addZooRequest.zooStatus);

        final ZooId zooId = commandBus.send(addZooCommand);

        return ResponseEntity.created(linkTo(methodOn(ZooController.class).getZooById(zooId.getValue())).toUri())
                .build();
    }

    @GetMapping("{zooId}")
    public ResponseEntity<?> getZooById(@PathVariable Long zooId) {

        Zoo zoo = queryBus.send(new RetrieveZooById(zooId));

        var zooResponse = ZooResponse.builder()
                .name(zoo.getName())
                .location(zoo.getLocation())
                .size(zoo.getSize())
                .spaceCapacity(zoo.getSpaceCapacity())
                .peopleCapacity(zoo.getPeopleCapacity())
                .zooStatus(zoo.getZooStatus().name())
                .build();

        return ResponseEntity.ok(zooResponse);
    }
}
