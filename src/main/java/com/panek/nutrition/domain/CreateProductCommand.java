package com.panek.nutrition.domain;

public record CreateProductCommand(
        String name,
        String barcode,
        int fatPer100g,
        int carbohydratesPer100g,
        int proteinsPer100g
) {
}
