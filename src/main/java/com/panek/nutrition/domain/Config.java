package com.panek.nutrition.domain;

public final class Config {

    public static NutritionFacade nutritionFacade(
            MealRepository mealRepository,
            MealIdGenerator mealIdGenerator,
            ProductDefinitionRepository productDefinitionRepository,
            ProductIdGenerator productIdGenerator
    ) {
        return new NutritionFacade(productDefinitionRepository, productIdGenerator, mealIdGenerator, mealRepository);
    }
}
