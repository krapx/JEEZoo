package com.example.jeezoo.animal.application.query;

import com.example.jeezoo.animal.domain.Animal;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.kernel.cqs.QueryHandler;

import java.util.List;

public final class RetrieveAllAnimalsQueryHandler implements QueryHandler<RetrieveAllAnimals, List<Animal>> {

    private Animals animals;

    public RetrieveAllAnimalsQueryHandler(Animals animals) {
        this.animals = animals;
    }

    @Override
    public List<Animal> handle(RetrieveAllAnimals query) {
        return animals.findAll();
    }
}
