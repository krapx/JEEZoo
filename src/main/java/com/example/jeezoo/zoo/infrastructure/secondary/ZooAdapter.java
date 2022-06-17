package com.example.jeezoo.zoo.infrastructure.secondary;

import com.example.jeezoo.kernel.Adapter;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity.ZooEntity;
import org.springframework.stereotype.Component;

@Component
public final class ZooAdapter implements Adapter<Zoo, ZooEntity> {

    @Override
    public ZooEntity adapt(Zoo source) {
        return new ZooEntity(source.getId().getValue(), source.getName(), source.getZooStatus().name());
    }
}
