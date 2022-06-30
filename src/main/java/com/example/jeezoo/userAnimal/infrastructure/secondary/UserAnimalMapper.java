package com.example.jeezoo.userAnimal.infrastructure.secondary;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.domain.UserAnimalDamage;
import com.example.jeezoo.userAnimal.domain.UserAnimalId;
import org.springframework.stereotype.Component;

@Component
public class UserAnimalMapper {

    public UserAnimal toModel(UserAnimalEntity userAnimalEntity) {
        return UserAnimal.of(
            UserAnimalId.of(userAnimalEntity.getId()),
            UserAnimalDamage.of(userAnimalEntity.getDamage()),
            userAnimalEntity.getName(),
            userAnimalEntity.getImage(),
            userAnimalEntity.getCreationAt(),
            userAnimalEntity.getUpdatedAt(),
            UserId.of(userAnimalEntity.getUserId())
        );
    }

    public UserAnimalEntity toEntity(UserAnimal userAnimal) {
        return new UserAnimalEntity(
            userAnimal.getId().getValue(),
            userAnimal.getDamage().getValue(),
            userAnimal.getName(),
            userAnimal.getImage(),
            userAnimal.getCreationAt(),
            userAnimal.getUpdatedAt(),
            userAnimal.getUserId().getValue()
        );
    }
}
