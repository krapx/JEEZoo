package com.example.jeezoo.space.application;

import com.example.jeezoo.space.domain.Space;
import com.example.jeezoo.space.domain.SpaceId;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.space.domain.Spaces;
import com.example.jeezoo.zoo.domain.ZooId;
import com.example.jeezoo.zoo.domain.ZooService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpaceServiceTest {

    @Autowired
    Spaces spaces;
    SpaceService spaceService;
    @Autowired
    ZooService zooService;

    @BeforeEach
    void setUp() {
        spaceService = new SpaceService(spaces, zooService);
    }

    @Test
    void should_retrieve_initial_space_list_when_no_spaces_added() {
        var spaces = spaceService.getAll();

        assertThat(spaces).hasSize(2);
    }

    @Test
    void should_add_new_space() {
        Space space = Space.createSpace(
                "test",
                "COMPLETED",
                ZooId.of(1000L)
        );
        spaceService.save(space);

        assertThat(space.getZooId()).isEqualTo(ZooId.of(1000L));
    }

    @Test
    void should_get_by_id() {
        var space = spaceService.getById(SpaceId.of(1200L));
        assertThat(space.getName()).isEqualTo("water");
    }
}
