package com.panek.nutrition.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.panek.nutrition.domain.builders.ProductDefinitionBuilder.aProductDefinition;
import static org.assertj.core.api.Assertions.assertThat;

public class MealTest {

    @Test
    void shouldSumCaloriesFromProductUsages() {
        var meal = aMeal(
                new ProductUsage(
                        aProductDefinition()
                                .withProteinPer100g(1) // 4kcal
                                .withCarbohydratePer100g(2) // 8kcal
                                .withFatPer100g(10) // 70kcal
                                .build(),
                        100 // 82kcal
                ),
                new ProductUsage(
                        aProductDefinition()
                                .withProteinPer100g(3) // 12kcal
                                .withCarbohydratePer100g(1) // 4kcal
                                .withFatPer100g(5) // 35kcal
                                .build(),
                        50 // 25kcal
                )
        );

        assertThat(meal.getTotalCalories()).isEqualTo(82 + 25);
    }

    private Meal aMeal(ProductUsage... productUsages) {
        return new Meal(
                "an-id",
                "a-name",
                Arrays.stream(productUsages).toList()
        );
    }
}
