package com.example.jeezoo.fight.exposition;

import com.example.jeezoo.fight.application.command.CreateFightCmd;
import com.example.jeezoo.fight.application.command.DeleteFightByIdCmd;
import com.example.jeezoo.fight.application.command.UpdateFightCmd;
import com.example.jeezoo.fight.application.query.ReadFightByIdQuery;
import com.example.jeezoo.fight.application.query.ReadFightQuery;
import com.example.jeezoo.fight.domain.Fight;
import com.example.jeezoo.fight.exposition.request.CreateFightRequest;
import com.example.jeezoo.fight.exposition.request.UpdateFightRequest;
import com.example.jeezoo.fight.exposition.response.FightResponse;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fights")
public class FightController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public FightController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateFightRequest request) {
        Long id = commandBus.send(new CreateFightCmd(request.title));
        return ResponseEntity.created(URI.create(id.toString())).build();
    }

    @GetMapping
    public List<FightResponse> readAll() {
        List<Fight> fights = queryBus.send(new ReadFightQuery());
        return fights.stream().map(FightResponse::fromFight).collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("{id}")
    public ResponseEntity<FightResponse> readById(@PathVariable("id") Long id) {
        Fight fight = queryBus.send(new ReadFightByIdQuery(id));
        return ResponseEntity.ok(FightResponse.fromFight(fight));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateFightRequest request) {
        commandBus.send(
            UpdateFightCmd.builder()
                .id(request.id)
                .title(request.title)
                .build()
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable("id") Long id) {
        commandBus.send(new DeleteFightByIdCmd(id));
        return ResponseEntity.accepted().build();
    }
}





