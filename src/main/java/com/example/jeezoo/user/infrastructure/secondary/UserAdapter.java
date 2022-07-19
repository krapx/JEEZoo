package com.example.jeezoo.user.infrastructure.secondary;

import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.user.domain.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public User toModel(UserEntity userEntity) {
        return User.of(
            UserId.of(userEntity.getId()),
            userEntity.getUsername(),
            userEntity.getPassword(),
            userEntity.getMail(),
            UserRole.valueOf(userEntity.getRole())
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
            user.getId().getValue(),
            user.getUsername(),
            user.getPassword(),
            user.getMail(),
            user.getUserRole().name()
        );
    }
}
