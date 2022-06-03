package com.example.jeezoo.zoo.infrastructure.secondary;

import com.example.jeezoo.kernel.Adapter;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooStatus;
import com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity.ZooEntity;
import org.springframework.stereotype.Component;

@Component
public class ZooMapper implements Adapter<ZooEntity, Zoo> {
    @Override
    public Zoo adapt(ZooEntity source) {
        return Zoo.of(ZooId.of(source.getZooId()), source.getName(), source.getLocation(), source.getSize(),
                source.getSpaceCapacity(), source.getPeopleCapacity(), ZooStatus.valueOf(source.getZooStatus()));
    }
}
