package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.domain.UserAnimalDamage;
import com.example.jeezoo.userAnimal.domain.UserAnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user-animals")
public class UserAnimalController {

    private final UserAnimalService userAnimalService;

    public UserAnimalController(UserAnimalService userAnimalService) {
        this.userAnimalService = userAnimalService;
    }

    @GetMapping("userId/{userId}")
    public ResponseEntity<UserAnimalResponse> findByUserId(@PathVariable Long userId) {
        UserAnimal userAnimal = userAnimalService.findByUserId(UserId.of(userId));
        return ResponseEntity.ok(UserAnimalResponse.fromUserAnimal(userAnimal));
    }

    @PostMapping
    public ResponseEntity<?> create(CreateUserAnimalRequest request) {
        userAnimalService.create(
            UserAnimal.create(
                request.name(),
                request.image(),
                UserId.of(request.userId())
            )
        );

        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<?> update(UpdateUserAnimalRequest request) {
        UserAnimal existing = userAnimalService.findByUserId(UserId.of(request.userId()));

        UserAnimal updated = UserAnimal.of(
            existing.getId(),
            UserAnimalDamage.of(request.damage()),
            request.name(),
            request.image(),
            existing.getCreationAt(),
            LocalDateTime.now(),
            UserId.of(request.userId())
        );

        userAnimalService.update(updated);

        return ResponseEntity.accepted().build();
    }
}
