package com.panek.nutrition.domain;

public record ProductDefinition(
        String id,
        String name,
        String barcode,
        Macronutrient.Fat fatPer100g,
        Macronutrient.Carbohydrate carbohydratePer100g,
        Macronutrient.Protein proteinPer100g
) {
}
