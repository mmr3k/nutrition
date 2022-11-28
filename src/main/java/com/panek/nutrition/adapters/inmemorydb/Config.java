package com.panek.nutrition.adapters.inmemorydb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public InMemoryMealRepository mealRepository() {
        return new InMemoryMealRepository();
    }

    @Bean
    public InMemoryProductDefinitionRepository productDefinitionRepository() {
        return new InMemoryProductDefinitionRepository();
    }
}
