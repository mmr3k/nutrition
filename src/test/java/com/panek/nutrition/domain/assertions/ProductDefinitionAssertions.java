package com.panek.nutrition.domain.assertions;

import com.panek.nutrition.domain.ProductDefinition;

public class ProductDefinitionAssertions {

    private final ProductDefinition value;

    public ProductDefinitionAssertions(ProductDefinition value) {
        this.value = value;
    }

    public static ProductDefinitionAssertions assertThat(ProductDefinition value) {
        return new ProductDefinitionAssertions(value);
    }

    public ProductDefinitionAssertions hasId(String value) {
        assert this.value.id().equals(value);
        return this;
    }

    public ProductDefinitionAssertions hasName(String value) {
        assert this.value.name().equals(value);
        return this;
    }

    public ProductDefinitionAssertions hasBarcode(String value) {
        assert this.value.barcode().equals(value);
        return this;
    }

    public ProductDefinitionAssertions hasFat(int value) {
        assert this.value.fatPer100g().getAmount() == value;
        return this;
    }

    public ProductDefinitionAssertions hasCarbohydrate(int value) {
        assert this.value.carbohydratePer100g().getAmount() == value;
        return this;
    }

    public ProductDefinitionAssertions hasProtein(int value) {
        assert this.value.proteinPer100g().getAmount() == value;
        return this;
    }

}
