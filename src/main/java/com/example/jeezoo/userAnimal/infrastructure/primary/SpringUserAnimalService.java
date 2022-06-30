package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.kernel.annotations.Service;
import com.example.jeezoo.userAnimal.domain.UserAnimalService;
import com.example.jeezoo.userAnimal.domain.UserAnimals;

@Service
public class SpringUserAnimalService extends UserAnimalService {

    public SpringUserAnimalService(UserAnimals userAnimals) {
        super(userAnimals);
    }
}
