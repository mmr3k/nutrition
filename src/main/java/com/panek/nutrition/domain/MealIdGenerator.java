package com.panek.nutrition.domain;

import java.util.UUID;

public interface MealIdGenerator {

    String generate();

    class Default implements MealIdGenerator {
        public String generate() {
            return UUID.randomUUID().toString();
        }
    }
}
