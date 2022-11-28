package com.panek.nutrition.domain;

import java.util.List;

public record CreateMealCommand(
        String name,
        List<ProductWithWeight> products
) {

    public record ProductWithWeight(String productId, int weight) {
    }
}
