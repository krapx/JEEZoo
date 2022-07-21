package com.example.jeezoo.player.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
@Accessors(chain = true)
public class Player {

    private final PlayerId id;
    private final String username;
    private final String password;
    private final String mail;
    private final PlayerRole playerRole;
    private final LocalDateTime creationAt;
    private final LocalDateTime updatedAt;

    public static Player create(
        String username,
        String password,
        String mail,
        PlayerRole playerRole
    ) {
        return new Player(
            PlayerId.notCreatedYet(),
            username,
            password,
            mail,
                playerRole,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }


}
