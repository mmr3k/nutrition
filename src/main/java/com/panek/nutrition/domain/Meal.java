package com.panek.nutrition.domain;

import java.util.List;

public record Meal(
        String id,
        String name,
        List<ProductUsage> usedProducts
) {

    public int getTotalCalories() {
        return usedProducts.stream().mapToInt(ProductUsage::getTotalCalories).sum();
    }
}
