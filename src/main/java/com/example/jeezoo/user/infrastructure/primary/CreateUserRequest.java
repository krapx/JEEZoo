package com.example.jeezoo.user.infrastructure.primary;

public record CreateUserRequest(
        String username,
        String password
) {
}
