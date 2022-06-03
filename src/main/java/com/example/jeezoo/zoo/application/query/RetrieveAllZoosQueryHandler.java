package com.example.jeezoo.zoo.application.query;

import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.Zoos;

import java.util.List;

public class RetrieveAllZoosQueryHandler implements QueryHandler<RetrieveAllZoosQuery, List<Zoo>> {

    private Zoos zoos;

    public RetrieveAllZoosQueryHandler(Zoos zoos) {
        this.zoos = zoos;
    }

    @Override
    public List<Zoo> handle(RetrieveAllZoosQuery query) {
        return zoos.findAll();
    }
}
