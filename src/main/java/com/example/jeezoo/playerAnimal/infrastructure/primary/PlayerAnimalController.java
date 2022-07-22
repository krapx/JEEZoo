package com.example.jeezoo.playerAnimal.infrastructure.primary;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.playerAnimal.domain.*;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/player-animals")
public class PlayerAnimalController {

    private final PlayerAnimalService playerAnimalService;
    private final PlayerAnimals playerAnimalRepository;

    public PlayerAnimalController(PlayerAnimalService playerAnimalService, PlayerAnimals playerAnimalRepository) {
        this.playerAnimalService = playerAnimalService;
        this.playerAnimalRepository = playerAnimalRepository;
    }

    @GetMapping
    public ResponseEntity<List<PlayerAnimalResponse>> collectAllAnimals() {
        return ResponseEntity.ok(playerAnimalRepository
            .findAll()
            .stream()
            .map(PlayerAnimalResponse::fromPlayerAnimal)
            .toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerAnimalResponse> getById(@PathVariable Long id) {
        PlayerAnimal playerAnimal = playerAnimalService.findById(PlayerAnimalId.of(id));
        return ResponseEntity.ok(PlayerAnimalResponse.fromPlayerAnimal(playerAnimal));
    }

    @GetMapping("playerId/{playerId}")
    public ResponseEntity<PlayerAnimalResponse> getByPlayerId(@PathVariable Long playerId) {
        PlayerAnimal playerAnimal = playerAnimalService.findByPlayerId(PlayerId.of(playerId));
        return ResponseEntity.ok(PlayerAnimalResponse.fromPlayerAnimal(playerAnimal));
    }

    @GetMapping("zooId/{zooId}")
    public List<PlayerAnimalResponse> getAllByZooId(@PathVariable Long zooId) {
        List<PlayerAnimal> playerAnimal = playerAnimalRepository.findAllByZooId(ZooId.of(zooId));
        return playerAnimal.stream().map(PlayerAnimalResponse::fromPlayerAnimal).toList();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreatePlayerAnimalRequest request) {
        PlayerAnimalId playerAnimalId = playerAnimalService.create(
            PlayerAnimal.create(
                request.name(),
                request.image(),
                PlayerId.of(request.playerId()),
                ZooId.of(request.zooId())
            )
        );

        return ResponseEntity.created(
            linkTo(methodOn(PlayerAnimalController.class).getById(playerAnimalId.getValue())).toUri()
        ).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdatePlayerAnimalRequest request) {
        PlayerAnimal existing = playerAnimalService.findByPlayerId(PlayerId.of(request.playerId()));

        PlayerAnimal updated = PlayerAnimal.of(
            existing.getId(),
            PlayerAnimalDamage.of(request.damage()),
            request.name(),
            request.image(),
            existing.getCreationAt(),
            LocalDateTime.now(),
            PlayerId.of(request.playerId()),
            ZooId.of(request.zooId())
        );

        playerAnimalService.update(updated);

        return ResponseEntity.accepted().build();
    }
}
