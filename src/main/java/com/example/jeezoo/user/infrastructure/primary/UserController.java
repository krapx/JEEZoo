package com.example.jeezoo.user.infrastructure.primary;

import com.example.jeezoo.user.domain.UserRepository;
import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.user.domain.model.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserId> createUser(CreateUserRequest createUserRequest) {
        System.out.println("CREATE USER");

        User userToAdd = User.of(createUserRequest.username(), createUserRequest.password(), UserRole.PLAYER, "test@gmail.com", UserId.create());
        System.out.println("1");
        UserId userId = userRepository.add(userToAdd);
        System.out.println("2");
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
