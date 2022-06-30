package com.example.jeezoo.userAnimal.domain.exception;

import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimalId;

public class UserAnimalNotFoundException extends RuntimeException {

    public UserAnimalNotFoundException(UserAnimalId userAnimalId) {
        super("UserAnimal with id \"" + userAnimalId.getValue() + "\" not found");
    }
    public UserAnimalNotFoundException(UserId userId) {
        super("UserAnimal with UserId.id \"" + userId.getValue() + "\" not found");
    }
}
