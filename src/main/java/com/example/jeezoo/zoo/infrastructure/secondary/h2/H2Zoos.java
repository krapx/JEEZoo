package com.example.jeezoo.zoo.infrastructure.secondary.h2;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.zoo.domain.Zoo;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.Zoos;
import com.example.jeezoo.zoo.infrastructure.secondary.ZooAdapter;
import com.example.jeezoo.zoo.infrastructure.secondary.ZooMapper;
import com.example.jeezoo.zoo.infrastructure.secondary.jpa.JpaZoos;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class H2Zoos implements Zoos {

    private final Logger logger = Logger.getLogger(H2Zoos.class.getName());
    private final JpaZoos jpaZoos;
    private final ZooAdapter zooAdapter;
    private final ZooMapper zooMapper;

    public H2Zoos(JpaZoos jpaZoos, ZooAdapter zooAdapter, ZooMapper zooMapper) {
        this.jpaZoos = jpaZoos;
        this.zooAdapter = zooAdapter;
        this.zooMapper = zooMapper;
    }


    @Override
    public ZooId save(Zoo zoo) {
        logger.info(String.format("SAVE %s", zoo));
        var zooSaved = jpaZoos.save(zooAdapter.adapt(zoo));
        return ZooId.of(zooSaved.getId());
    }

    @Override
    public Optional<Zoo> findById(ZooId zooId) {
        logger.info(String.format("FIND BY ID %s", zooId));
        return jpaZoos.findById(zooId.getValue()).map(zooMapper::adapt);
    }

    @Override
    public List<Zoo> findAll() {
        logger.info("FIND ALL");
        return jpaZoos.findAll().stream().map(zooMapper::adapt).toList();
    }

    @Override
    public List<Zoo> findAllByUserId(UserId userId) {
        return jpaZoos.findAllByUserId(userId.getValue()).stream().map(zooMapper::adapt).toList();
    }

    @Override
    public void deleteById(ZooId zooId) {
        logger.info(String.format("DELETE %s", zooId));
        jpaZoos.deleteById(zooId.getValue());
    }
}
