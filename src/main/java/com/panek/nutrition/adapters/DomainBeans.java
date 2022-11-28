package com.panek.nutrition.adapters;

import com.panek.nutrition.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeans {

    @Bean
    public NutritionFacade nutritionFacade(
            ProductDefinitionRepository productDefinitionRepository,
            MealRepository mealRepository
    ) {
        return Config.nutritionFacade(
                mealRepository,
                new MealIdGenerator.Default(),
                productDefinitionRepository,
                new ProductIdGenerator.Default()
        );
    }
}
