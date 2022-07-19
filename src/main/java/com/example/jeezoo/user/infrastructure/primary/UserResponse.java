package com.example.jeezoo.user.infrastructure.primary;

import com.example.jeezoo.user.domain.model.User;

public record UserResponse(
    Long userId,
    String username,
    String role,
    String mail
) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(
            user.getId().getValue(),
            user.getUsername(),
            user.getMail(),
            user.getUserRole().name()
        );
    }
}

