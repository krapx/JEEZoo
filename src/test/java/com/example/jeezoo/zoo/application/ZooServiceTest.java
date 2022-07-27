package com.example.jeezoo.zoo.application;

import com.example.jeezoo.player.domain.model.PlayerId;

import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooService;
import com.example.jeezoo.zoo.domain.ZooStatus;
import com.example.jeezoo.zoo.domain.Zoos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ZooServiceTest {

    ZooService zooService;
    @Autowired
    Zoos zoos;

    @BeforeEach
    void setUp() {
        zooService = new DefaultZooService(zoos);
    }

    @Test
    void should_add_zoo(){
        var zooId = zooService.addZoo(
                "test",
                ZooStatus.IN_PROGRESS,
                PlayerId.of(1L)
        );
        assertThat(zooId.getValue()).isEqualTo(1);
    }

    @Test
    void should_get_by_id() {
        var zoo = zooService.getZooById(ZooId.of(1L));
        assertThat(zoo.getName()).isEqualTo("test");
    }
}
