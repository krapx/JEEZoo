package com.example.jeezoo;


import com.example.jeezoo.animal.application.DefaultAnimalService;
import com.example.jeezoo.animal.application.command.*;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimals;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimalsQueryHandler;
import com.example.jeezoo.animal.application.query.RetrieveAnimalById;
import com.example.jeezoo.animal.application.query.RetrieveAnimalByIdQueryHandler;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.kernel.cqs.*;
import com.example.jeezoo.space.application.SpringSpaceService;
import com.example.jeezoo.space.application.command.*;
import com.example.jeezoo.space.application.query.ReadSpaceByIdQuery;
import com.example.jeezoo.space.application.query.ReadSpaceByIdQueryHandler;
import com.example.jeezoo.space.application.query.ReadSpaceQuery;
import com.example.jeezoo.space.application.query.ReadSpaceQueryHandler;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.space.domain.Spaces;
import com.example.jeezoo.space.infrastructure.SpaceMapper;
import com.example.jeezoo.space.infrastructure.jpa.JpaSpaceRepository;
import com.example.jeezoo.space.infrastructure.jpa.h2.H2Spaces;
import com.example.jeezoo.zoo.application.DefaultZooService;
import com.example.jeezoo.zoo.application.command.*;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQuery;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQueryHandler;
import com.example.jeezoo.zoo.application.query.RetrieveZooById;
import com.example.jeezoo.zoo.application.query.RetrieveZooByIdQueryHandler;
import com.example.jeezoo.zoo.domain.ZooService;
import com.example.jeezoo.zoo.domain.Zoos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfiguration {

    private final Animals animals;
    private final Zoos zoos;
    private final JpaSpaceRepository jpaSpaceRepository;
    private final SpaceMapper spaceMapper;

    public ApplicationConfiguration(
        Animals animals,
        Zoos zoos,
        JpaSpaceRepository jpaSpaceRepository,
        SpaceMapper spaceMapper
    ) {
        this.animals = animals;
        this.zoos = zoos;
        this.jpaSpaceRepository = jpaSpaceRepository;
        this.spaceMapper = spaceMapper;
    }

    //Command bus
    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(AddAnimalCommand.class, new AddAnimalCommandHandler(animalService()));
        commandHandlerMap.put(DeleteAnimalCommand.class, new DeleteAnimalCommandHandler(animalService()));
        commandHandlerMap.put(
            UpdateAnimalCommand.class,
            new UpdateAnimalCommandHandler(animalService(), animals, spaceService(), H2SpaceRepository())
        );
        commandHandlerMap.put(AddZooCommand.class, new AddZooCommandHandler(zooService()));
        commandHandlerMap.put(DeleteZooCommand.class, new DeleteZooCommandHandler(zooService()));
        commandHandlerMap.put(UpdateZooCommand.class, new UpdateZooCommandHandler(zooService()));
        commandHandlerMap.put(CreateSpaceCmd.class, new CreateSpaceCmdHandler(spaceService()));
        commandHandlerMap.put(DeleteSpaceByIdCmd.class, new DeleteSpaceByIdCmdHandler(spaceService()));
        commandHandlerMap.put(UpdateSpaceCmd.class, new UpdateSpaceCmdHandler(spaceService()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    //Query bus
    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap = new HashMap<>();
        queryHandlerMap.put(RetrieveAnimalById.class, new RetrieveAnimalByIdQueryHandler(animals));
        queryHandlerMap.put(RetrieveZooById.class, new RetrieveZooByIdQueryHandler(zoos));
        queryHandlerMap.put(RetrieveAllZoosQuery.class, new RetrieveAllZoosQueryHandler(zoos));
        queryHandlerMap.put(RetrieveAllAnimals.class, new RetrieveAllAnimalsQueryHandler(animals));
        queryHandlerMap.put(ReadSpaceByIdQuery.class, new ReadSpaceByIdQueryHandler(spaceService()));
        queryHandlerMap.put(ReadSpaceQuery.class, new ReadSpaceQueryHandler(spaceService()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    //service singleton
    @Bean
    public AnimalService animalService() {
        return new DefaultAnimalService(animals);
    }

    @Bean
    public ZooService zooService() {
        return new DefaultZooService(zoos);
    }

    @Bean
    public SpaceService spaceService() {
        return new SpringSpaceService(H2SpaceRepository(), zooService());
    }

    @Bean
    public Spaces H2SpaceRepository() {
        return new H2Spaces(jpaSpaceRepository, spaceMapper);
    }

}
