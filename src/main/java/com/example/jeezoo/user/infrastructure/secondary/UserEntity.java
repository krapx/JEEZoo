package com.example.jeezoo.user.infrastructure.secondary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
public final class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String role;
    private LocalDateTime updatedAt;
    private LocalDateTime creationAt;

    public UserEntity() {
    }
}