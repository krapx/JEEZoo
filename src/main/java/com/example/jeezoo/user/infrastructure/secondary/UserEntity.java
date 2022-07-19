package com.example.jeezoo.user.infrastructure.secondary;

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
public final class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String role;
    @CreatedDate
    private LocalDateTime creationAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public UserEntity(Long id, String username, String password, String mail, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.role = role;
    }

    public UserEntity() {
    }
}