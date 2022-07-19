package com.example.jeezoo.user.infrastructure.primary;

import javax.validation.constraints.NotEmpty;

public record CreateUserRequest(
    @NotEmpty
    String username,
    @NotEmpty
    String password,
    @NotEmpty
    String email
) {
}
