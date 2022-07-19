package com.example.jeezoo.user.infrastructure.primary;

import com.example.jeezoo.user.domain.model.User;

import java.time.LocalDateTime;

public record UserResponse(
    Long userId,
    String username,
    String role,
    String mail,
    LocalDateTime creationAt,
    LocalDateTime updatedAt
) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(
            user.getId().getValue(),
            user.getUsername(),
            user.getMail(),
            user.getUserRole().name(),
            user.getCreationAt(),
            user.getUpdatedAt()
        );
    }
}

