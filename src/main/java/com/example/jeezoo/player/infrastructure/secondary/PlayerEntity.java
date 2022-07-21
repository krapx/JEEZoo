package com.example.jeezoo.player.infrastructure.secondary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
@Getter
@AllArgsConstructor
public final class PlayerEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String role;
    private LocalDateTime updatedAt;
    private LocalDateTime creationAt;

    public PlayerEntity() {
    }
}