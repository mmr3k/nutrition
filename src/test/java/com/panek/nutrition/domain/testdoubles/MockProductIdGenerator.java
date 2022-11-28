package com.panek.nutrition.domain.testdoubles;

import com.panek.nutrition.domain.ProductIdGenerator;

public class MockProductIdGenerator implements ProductIdGenerator {

    private String valueToReturn = "fake-product-id";

    @Override
    public String generate() {
        return valueToReturn;
    }

    public void alwaysReturns(String value) {
        valueToReturn = value;
    }
}
