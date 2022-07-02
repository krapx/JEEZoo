package com.example.jeezoo.user.infrastructure.secondary;

import com.example.jeezoo.user.domain.model.User;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.user.domain.model.UserRole;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.infrastructure.secondary.UserAnimalEntity;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    public User toModel(UserEntity userEntity) {
        return User.of(
                userEntity.getUsername(),
                userEntity.getPassword(),
                UserRole.fromString(userEntity.getRole()),
                userEntity.getMail(),
                UserId.of(userEntity.getUserId())
        );
    }

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.getUsername(),
                user.getPassword(),
                user.getUserRole().getValue(),
                user.getMail()
        );
    }
}
