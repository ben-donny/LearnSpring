package com.uprr.app.tng.spring.config;

import com.uprr.app.tng.spring.controller.HeartbeatController;
import com.uprr.app.tng.spring.controller.PokemonController;
import com.uprr.app.tng.spring.controller.PokemonLocationController;
import com.uprr.app.tng.spring.controller.advice.GlobalExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by david on 1/8/17.
 */
@Configuration
public class ControllerConfig {
    @Autowired private DaoConfig daoConfig;

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public HeartbeatController heartBeatController() {
        return new HeartbeatController();
    }

    @Bean
    public PokemonController pokemonController() {
        return new PokemonController(this.daoConfig.pokemonDao());
    }

    @Bean
    public PokemonLocationController pokemonLocationController() {
        return new PokemonLocationController(this.daoConfig.pokemonLocationDao());
    }
}
