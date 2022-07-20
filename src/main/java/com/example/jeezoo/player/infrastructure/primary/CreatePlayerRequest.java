package com.example.jeezoo.player.infrastructure.primary;

import javax.validation.constraints.NotEmpty;

public record CreatePlayerRequest(
    @NotEmpty
    String username,
    @NotEmpty
    String password,
    @NotEmpty
    String email
) {
}
