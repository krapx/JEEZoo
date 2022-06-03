package com.example.jeezoo.zoo.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.Zoos;

import javax.persistence.EntityNotFoundException;

public class RetrieveZooByIdQueryHandler implements QueryHandler<RetrieveZooById, Zoo> {

    private final Zoos zoos;

    public RetrieveZooByIdQueryHandler(Zoos zoos) {
        this.zoos = zoos;
    }

    @Override
    public Zoo handle(RetrieveZooById query) {
        ZooId zooId = ZooId.of(query.id);
        return zoos.findById(zooId).orElseThrow(() -> new EntityNotFoundException("no Zoo with ID: " +query.id));
    }
}
