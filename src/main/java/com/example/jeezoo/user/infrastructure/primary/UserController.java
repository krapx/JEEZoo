package com.example.jeezoo.user.infrastructure.primary;

import com.example.jeezoo.user.domain.UserRepository;
import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.user.domain.model.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(UserResponse::fromUser).toList();
    }

    @PostMapping
    public ResponseEntity<UserId> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        User userToAdd = User.create(
            createUserRequest.username(),
            createUserRequest.password(),
            createUserRequest.email(),
            UserRole.PLAYER
        );
        UserId userId = userRepository.add(userToAdd);
        return ResponseEntity
            .created(linkTo(methodOn(UserController.class).getUserById(userId.getValue())).toUri())
            .body(userId);
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        User user = userRepository.findById(UserId.of(userId));
        return ResponseEntity.ok(UserResponse.fromUser(user));
    }

}
