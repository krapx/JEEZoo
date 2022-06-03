package com.example.jeezoo.zooBreak.exposition;

import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.zooBreak.application.command.CreateZooBreakCmd;
import com.example.jeezoo.zooBreak.application.command.DeleteZooBreakByIdCmd;
import com.example.jeezoo.zooBreak.application.command.UpdateZooBreakCmd;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakByIdQuery;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakQuery;
import com.example.jeezoo.zooBreak.domain.ZooBreak;
import com.example.jeezoo.zooBreak.exposition.request.CreateZooBreakRequest;
import com.example.jeezoo.zooBreak.exposition.request.UpdateZooBreakRequest;
import com.example.jeezoo.zooBreak.exposition.response.ZooBreakResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/zooBreaks")
public class ZooBreakController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ZooBreakController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateZooBreakRequest request) {
        Long id = commandBus.send(new CreateZooBreakCmd(request.title));
        return ResponseEntity.created(URI.create(id.toString())).build();
    }

    @GetMapping
    public List<ZooBreakResponse> readAll() {
        List<ZooBreak> zooBreaks = queryBus.send(new ReadZooBreakQuery());
        return zooBreaks.stream().map(ZooBreakResponse::fromZooBreak).collect(Collectors.toUnmodifiableList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ZooBreakResponse> readById(@PathVariable("id") Long id) {
        ZooBreak zooBreak = queryBus.send(new ReadZooBreakByIdQuery(id));
        return ResponseEntity.ok(ZooBreakResponse.fromZooBreak(zooBreak));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateZooBreakRequest request) {
        commandBus.send(
            UpdateZooBreakCmd.builder()
                .id(request.id)
                .title(request.title)
                .build()
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@Valid @PathVariable("id") Long id) {
        commandBus.send(new DeleteZooBreakByIdCmd(id));
        return ResponseEntity.accepted().build();
    }
}





