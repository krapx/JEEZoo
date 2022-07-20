package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.*;
import com.example.jeezoo.zoo.domain.ZooId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/user-animals")
public class UserAnimalController {

    private final UserAnimalService userAnimalService;
    private final UserAnimals userAnimalRepository;

    public UserAnimalController(UserAnimalService userAnimalService, UserAnimals userAnimalRepository) {
        this.userAnimalService = userAnimalService;
        this.userAnimalRepository = userAnimalRepository;
    }

    @GetMapping
    public ResponseEntity<List<UserAnimalResponse>> collectAllAnimals() {
        return ResponseEntity.ok(userAnimalRepository
            .findAll()
            .stream()
            .map(UserAnimalResponse::fromUserAnimal)
            .toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserAnimalResponse> getById(@PathVariable Long id) {
        UserAnimal userAnimal = userAnimalService.findById(UserAnimalId.of(id));
        return ResponseEntity.ok(UserAnimalResponse.fromUserAnimal(userAnimal));
    }

    @GetMapping("userId/{userId}")
    public ResponseEntity<UserAnimalResponse> getByUserId(@PathVariable Long userId) {
        UserAnimal userAnimal = userAnimalService.findByUserId(UserId.of(userId));
        return ResponseEntity.ok(UserAnimalResponse.fromUserAnimal(userAnimal));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateUserAnimalRequest request) {
        UserAnimalId userAnimalId = userAnimalService.create(
            UserAnimal.create(
                request.name(),
                request.image(),
                UserId.of(request.userId()),
                ZooId.of(request.zooId())
            )
        );

        return ResponseEntity.created(
            linkTo(methodOn(UserAnimalController.class).getById(userAnimalId.getValue())).toUri()
        ).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateUserAnimalRequest request) {
        UserAnimal existing = userAnimalService.findByUserId(UserId.of(request.userId()));

        UserAnimal updated = UserAnimal.of(
            existing.getId(),
            UserAnimalDamage.of(request.damage()),
            request.name(),
            request.image(),
            existing.getCreationAt(),
            LocalDateTime.now(),
            UserId.of(request.userId()),
            ZooId.of(request.zooId())
        );

        userAnimalService.update(updated);

        return ResponseEntity.accepted().build();
    }
}
