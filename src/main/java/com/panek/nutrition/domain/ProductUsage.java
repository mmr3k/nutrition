package com.panek.nutrition.domain;

public record ProductUsage(
        ProductDefinition product,
        int weight
) {

    public int getTotalCalories() {
        int totalCaloriesPer100g = product.fatPer100g().getCalories() + product.carbohydratePer100g().getCalories() + product.proteinPer100g().getCalories();
        return weight * totalCaloriesPer100g / 100;
    }
}
