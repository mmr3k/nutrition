package com.panek.nutrition.domain;

public sealed abstract class NutritionException extends RuntimeException {

    public NutritionException(String message) {
        super(message);
    }

    static final class ProductDefinitionNotFound extends NutritionException {

        public ProductDefinitionNotFound(String productId) {
            super("Product with id: <" + productId + "> not found");
        }
    }

    static final class InvalidArgumentException extends NutritionException {

        public InvalidArgumentException(String message) {
            super(message);
        }
    }
}
