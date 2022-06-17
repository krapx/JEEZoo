package com.example.jeezoo;

import com.example.jeezoo.animal.application.DefaultAnimalService;
import com.example.jeezoo.animal.application.command.*;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimals;
import com.example.jeezoo.animal.application.query.RetrieveAllAnimalsQueryHandler;
import com.example.jeezoo.animal.application.query.RetrieveAnimalById;
import com.example.jeezoo.animal.application.query.RetrieveAnimalByIdQueryHandler;
import com.example.jeezoo.animal.domain.AnimalService;
import com.example.jeezoo.animal.domain.Animals;
import com.example.jeezoo.fight.application.SpringFightService;
import com.example.jeezoo.fight.application.command.*;
import com.example.jeezoo.fight.application.query.ReadFightByIdQuery;
import com.example.jeezoo.fight.application.query.ReadFightByIdQueryHandler;
import com.example.jeezoo.fight.application.query.ReadFightQuery;
import com.example.jeezoo.fight.application.query.ReadFightQueryHandler;
import com.example.jeezoo.fight.domain.FightRepository;
import com.example.jeezoo.fight.domain.FightService;
import com.example.jeezoo.fight.infrastructure.FightMapper;
import com.example.jeezoo.fight.infrastructure.jpa.JpaFightRepository;
import com.example.jeezoo.fight.infrastructure.jpa.h2.H2FightRepository;
import com.example.jeezoo.kernel.cqs.Command;
import com.example.jeezoo.kernel.cqs.CommandBus;
import com.example.jeezoo.kernel.cqs.CommandHandler;
import com.example.jeezoo.kernel.cqs.Query;
import com.example.jeezoo.kernel.cqs.QueryBus;
import com.example.jeezoo.kernel.cqs.QueryHandler;
import com.example.jeezoo.kernel.cqs.SimpleCommandBus;
import com.example.jeezoo.kernel.cqs.SimpleQueryBus;

import java.util.HashMap;
import java.util.Map;

import com.example.jeezoo.space.application.SpringSpaceService;
import com.example.jeezoo.space.application.command.*;
import com.example.jeezoo.space.application.query.ReadSpaceByIdQuery;
import com.example.jeezoo.space.application.query.ReadSpaceByIdQueryHandler;
import com.example.jeezoo.space.application.query.ReadSpaceQuery;
import com.example.jeezoo.space.application.query.ReadSpaceQueryHandler;
import com.example.jeezoo.space.domain.SpaceRepository;
import com.example.jeezoo.space.domain.SpaceService;
import com.example.jeezoo.space.infrastructure.SpaceMapper;
import com.example.jeezoo.space.infrastructure.jpa.JpaSpaceRepository;
import com.example.jeezoo.space.infrastructure.jpa.h2.H2SpaceRepository;
import com.example.jeezoo.zoo.application.DefaultZooService;
import com.example.jeezoo.zoo.application.command.*;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQuery;
import com.example.jeezoo.zoo.application.query.RetrieveAllZoosQueryHandler;
import com.example.jeezoo.zoo.application.query.RetrieveZooById;
import com.example.jeezoo.zoo.application.query.RetrieveZooByIdQueryHandler;
import com.example.jeezoo.zoo.domain.ZooService;
import com.example.jeezoo.zoo.domain.Zoos;
import com.example.jeezoo.zooBreak.application.SpringZooBreakService;
import com.example.jeezoo.zooBreak.application.command.*;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakByIdQuery;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakByIdQueryHandler;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakQuery;
import com.example.jeezoo.zooBreak.application.query.ReadZooBreakQueryHandler;
import com.example.jeezoo.zooBreak.domain.ZooBreakRepository;
import com.example.jeezoo.zooBreak.domain.ZooBreakService;
import com.example.jeezoo.zooBreak.infrastructure.ZooBreakMapper;
import com.example.jeezoo.zooBreak.infrastructure.jpa.JpaZooBreakRepository;
import com.example.jeezoo.zooBreak.infrastructure.jpa.h2.H2ZooBreakRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    private final Animals animals;
    private final Zoos zoos;
    private final JpaSpaceRepository jpaSpaceRepository;
    private final SpaceMapper spaceMapper;
    private final JpaFightRepository jpaFightRepository;
    private final FightMapper fightMapper;
    private final JpaZooBreakRepository jpaZooBreakRepository;
    private final ZooBreakMapper zooBreakMapper;

    public ApplicationConfiguration(
        Animals animals,
        Zoos zoos,
        JpaSpaceRepository jpaSpaceRepository,
        SpaceMapper spaceMapper,
        JpaFightRepository jpaFightRepository, FightMapper fightMapper,
        JpaZooBreakRepository jpaZooBreakRepository, ZooBreakMapper zooBreakMapper
    ) {
        this.animals = animals;
        this.zoos = zoos;
        this.jpaSpaceRepository = jpaSpaceRepository;
        this.spaceMapper = spaceMapper;
        this.jpaFightRepository = jpaFightRepository;
        this.fightMapper = fightMapper;
        this.jpaZooBreakRepository = jpaZooBreakRepository;
        this.zooBreakMapper = zooBreakMapper;
    }

    //Command bus
    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(AddAnimalCommand.class, new AddAnimalCommandHandler(animalService()));
        commandHandlerMap.put(DeleteAnimalCommand.class, new DeleteAnimalCommandHandler(animalService()));
        commandHandlerMap.put(UpdateAnimalCommand.class, new UpdateAnimalCommandHandler(animalService()));
        commandHandlerMap.put(AddZooCommand.class, new AddZooCommandHandler(zooService()));
        commandHandlerMap.put(DeleteZooCommand.class, new DeleteZooCommandHandler(zooService()));
        commandHandlerMap.put(UpdateZooCommand.class, new UpdateZooCommandHandler(zooService()));
        commandHandlerMap.put(CreateSpaceCmd.class, new CreateSpaceCmdHandler(spaceService()));
        commandHandlerMap.put(DeleteSpaceByIdCmd.class, new DeleteSpaceByIdCmdHandler(spaceService()));
        commandHandlerMap.put(UpdateSpaceCmd.class, new UpdateSpaceCmdHandler(spaceService()));
        commandHandlerMap.put(CreateFightCmd.class, new CreateFightCmdHandler(fightService()));
        commandHandlerMap.put(DeleteFightByIdCmd.class, new DeleteFightByIdCmdHandler(fightService()));
        commandHandlerMap.put(UpdateFightCmd.class, new UpdateFightCmdHandler(fightService()));
        commandHandlerMap.put(CreateZooBreakCmd.class, new CreateZooBreakCmdHandler(zooBreakService()));
        commandHandlerMap.put(DeleteZooBreakByIdCmd.class, new DeleteZooBreakByIdCmdHandler(zooBreakService()));
        commandHandlerMap.put(UpdateZooBreakCmd.class, new UpdateZooBreakCmdHandler(zooBreakService()));
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
        queryHandlerMap.put(ReadFightByIdQuery.class, new ReadFightByIdQueryHandler(fightService()));
        queryHandlerMap.put(ReadFightQuery.class, new ReadFightQueryHandler(fightService()));
        queryHandlerMap.put(ReadZooBreakByIdQuery.class, new ReadZooBreakByIdQueryHandler(zooBreakService()));
        queryHandlerMap.put(ReadZooBreakQuery.class, new ReadZooBreakQueryHandler(zooBreakService()));
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
    public SpaceRepository H2SpaceRepository() {
        return new H2SpaceRepository(jpaSpaceRepository, spaceMapper);
    }

    @Bean
    public FightService fightService() {
        return new SpringFightService(H2FightRepository());
    }

    @Bean
    public FightRepository H2FightRepository() {
        return new H2FightRepository(jpaFightRepository, fightMapper);
    }

    @Bean
    public ZooBreakService zooBreakService() {
        return new SpringZooBreakService(H2ZooBreakRepository());
    }

    @Bean
    public ZooBreakRepository H2ZooBreakRepository() {
        return new H2ZooBreakRepository(jpaZooBreakRepository, zooBreakMapper);
    }
}
