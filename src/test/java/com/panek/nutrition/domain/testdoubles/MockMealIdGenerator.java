package com.panek.nutrition.domain.testdoubles;

import com.panek.nutrition.domain.MealIdGenerator;

public class MockMealIdGenerator implements MealIdGenerator {

    private String valueToReturn = "fake-meal-id";

    @Override
    public String generate() {
        return valueToReturn;
    }

    public void alwaysReturns(String value) {
        valueToReturn = value;
    }
}
