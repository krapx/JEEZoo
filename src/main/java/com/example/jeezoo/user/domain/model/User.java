package com.example.jeezoo.user.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class User {

    private final UserId id;
    private final String username;
    private final String password;
    private final String mail;
    private final UserRole userRole;
    private final LocalDateTime creationAt;
    private final LocalDateTime updatedAt;

    public static User create(
        String username,
        String password,
        String mail,
        UserRole userRole
    ) {
        return new User(
            UserId.notCreatedYet(),
            username,
            password,
            mail,
            userRole,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}
