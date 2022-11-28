package com.panek.nutrition.domain;

import com.panek.nutrition.domain.builders.ProductDefinitionBuilder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.panek.nutrition.domain.builders.ProductDefinitionBuilder.aProductDefinition;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductUsageTest {

    @ParameterizedTest
    @CsvSource({
            "100,20,30,50,460",
            "200,20,30,50,920",
            "50,20,30,50,230"
    })
    void shouldSumCaloriesFromMacronutrients(
            int productWeight,
            int fat,
            int carbohydrate,
            int protein,
            int expectedCaloriesSum
    ) {
        var productDefinition = aProductDefinition()
                .withFatPer100g(fat)
                .withCarbohydratePer100g(carbohydrate)
                .withProteinPer100g(protein)
                .build();

        var productUsage = new ProductUsage(productDefinition, productWeight);

        assertThat(productUsage.getTotalCalories()).isEqualTo(expectedCaloriesSum);
    }
}
