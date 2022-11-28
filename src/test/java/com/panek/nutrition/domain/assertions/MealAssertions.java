package com.panek.nutrition.domain.assertions;

import com.panek.nutrition.domain.Meal;
import com.panek.nutrition.domain.ProductUsage;

public class MealAssertions {

    private final Meal value;

    public MealAssertions(Meal value) {
        this.value = value;
    }

    public static MealAssertions assertThat(Meal value) {
        return new MealAssertions(value);
    }

    public MealAssertions hasId(String value) {
        assert this.value.id().equals(value);
        return this;
    }

    public MealAssertions hasName(String value) {
        assert this.value.name().equals(value);
        return this;
    }

    public MealAssertions hasProductUsagesOfSize(int value) {
        assert this.value.usedProducts().size() == value;
        return this;
    }

    public ProductUsageAssertions hasProductUsageForProductIdThat(String value) {
        var productUsage = this.value.usedProducts()
                .stream()
                .filter(p -> p.product().id().equals(value))
                .findFirst();
        assert productUsage.isPresent();
        return new ProductUsageAssertions(productUsage.get());
    }

    public class ProductUsageAssertions extends MealAssertions {

        private final ProductUsage value;

        public ProductUsageAssertions(ProductUsage value) {
            super(MealAssertions.this.value);
            this.value = value;
        }

        public ProductUsageAssertions hasWeight(int value) {
            assert this.value.weight() == value;
            return this;
        }
    }

}
