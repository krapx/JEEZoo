package com.example.jeezoo.zoo.infrastructure.primary;

import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.zoo.application.command.AddZooCommand;
import com.example.jeezoo.zoo.application.command.DeleteZooCommand;
import com.example.jeezoo.zoo.application.command.UpdateZooCommand;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQuery;
import com.example.jeezoo.zoo.application.query.RetrieveZooById;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.infrastructure.primary.request.AddZooRequest;
import com.example.jeezoo.zoo.infrastructure.primary.request.UpdateZooRequest;
import com.example.jeezoo.zoo.infrastructure.primary.response.ZooResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/zoos")
public class ZooController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ZooController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping("")
    public ResponseEntity<Void> addZoo(@RequestBody @Valid AddZooRequest addZooRequest) {
        var addZooCommand = new AddZooCommand(
            addZooRequest.name,
            addZooRequest.zooStatus
        );

        final ZooId zooId = commandBus.send(addZooCommand);

        return ResponseEntity.created(linkTo(methodOn(ZooController.class).getZooById(zooId.getValue())).toUri())
            .build();
    }

    @GetMapping
    public List<ZooResponse> getAllZoos() {
        List<Zoo> zoos = queryBus.send(new RetrieveAllZoosQuery());

        return zoos.stream().map(zoo -> {
            return ZooResponse.builder()
                .id(zoo.getId().getValue())
                .name(zoo.getName())
                .zooStatus(zoo.getZooStatus().name())
                .build();
        }).collect(Collectors.toList());
    }

    @GetMapping("{zooId}")
    public ResponseEntity<?> getZooById(@PathVariable Long zooId) {

        Zoo zoo = queryBus.send(new RetrieveZooById(zooId));

        var zooResponse = ZooResponse.builder()
            .name(zoo.getName())
            .zooStatus(zoo.getZooStatus().name())
            .build();

        return ResponseEntity.ok(zooResponse);
    }

    @PutMapping("{zooId}")
    public ResponseEntity<?> updateZooById(
        @RequestBody @Valid UpdateZooRequest updateZooRequest, @PathVariable Long zooId
    ) {
        var updateZooById = new UpdateZooCommand(
            zooId,
            updateZooRequest.name,
            updateZooRequest.zooStatus
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
