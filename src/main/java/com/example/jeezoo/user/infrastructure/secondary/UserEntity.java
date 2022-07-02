package com.example.jeezoo.user.infrastructure.secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "user")
@Data
@NoArgsConstructor
public final class UserEntity {

    public UserEntity(String username, String password, String role, String mail) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.mail = mail;
    }

    @Id
    @GeneratedValue
    private Long userId;

    private String username;

    private String password;

    private String role;

    private String mail;

    @CreatedDate
    private LocalDateTime creationAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}