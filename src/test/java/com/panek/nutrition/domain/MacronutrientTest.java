package com.panek.nutrition.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MacronutrientTest {

    @Test
    void shouldCalculateCaloriesInFat() {
        var fat = Macronutrient.fat(11);
        assertThat(fat.getCalories()).isEqualTo(77);
    }

    @Test
    void shouldCalculateCaloriesInCarbohydrate() {
        var fat = Macronutrient.carbohydrate(11);
        assertThat(fat.getCalories()).isEqualTo(44);
    }

    @Test
    void shouldCalculateCaloriesInProtein() {
        var fat = Macronutrient.protein(11);
        assertThat(fat.getCalories()).isEqualTo(44);
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void shouldThrowForInvalidAmountInFat(int invalidAmount) {
        assertThatThrownBy(() -> Macronutrient.fat(invalidAmount))
                .isInstanceOf(NutritionException.InvalidArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void shouldThrowForInvalidAmountInCarbohydrate(int invalidAmount) {
        assertThatThrownBy(() -> Macronutrient.carbohydrate(invalidAmount))
                .isInstanceOf(NutritionException.InvalidArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidAmounts")
    void shouldThrowForInvalidAmountInProtein(int invalidAmount) {
        assertThatThrownBy(() -> Macronutrient.protein(invalidAmount))
                .isInstanceOf(NutritionException.InvalidArgumentException.class);
    }

    static int[] invalidAmounts() {
        return new int[] {-10, -1, 101, 110};
    }
}
