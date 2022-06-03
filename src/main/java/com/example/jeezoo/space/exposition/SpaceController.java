package com.example.jeezoo.space.exposition;

import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.space.application.command.CreateSpaceCmd;
import com.example.jeezoo.space.application.command.DeleteSpaceByIdCmd;
import com.example.jeezoo.space.application.command.UpdateSpaceCmd;
import com.example.jeezoo.space.application.query.ReadSpaceByIdQuery;
import com.example.jeezoo.space.application.query.ReadSpaceQuery;
import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.exposition.request.CreateSpaceRequest;
import com.example.jeezoo.space.exposition.request.UpdateSpaceRequest;
import com.example.jeezoo.space.exposition.response.SpaceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public SpaceController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateSpaceRequest request) {
        Long id = commandBus.send(new CreateSpaceCmd(request.title));
        return ResponseEntity.created(URI.create(id.toString())).build();
    }

    @GetMapping
    public List<SpaceResponse> readAll() {
        List<Space> spaces = queryBus.send(new ReadSpaceQuery());
        return spaces.stream().map(SpaceResponse::fromSpace).collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("{id}")
    public ResponseEntity<SpaceResponse> readById(@PathVariable("id") Long id) {
        Space space = queryBus.send(new ReadSpaceByIdQuery(id));
        return ResponseEntity.ok(SpaceResponse.fromSpace(space));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateSpaceRequest request) {
        commandBus.send(
            UpdateSpaceCmd.builder()
                .id(request.id)
                .title(request.title)
                .build()
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable("id") Long id) {
        commandBus.send(new DeleteSpaceByIdCmd(id));
        return ResponseEntity.accepted().build();
    }
}





