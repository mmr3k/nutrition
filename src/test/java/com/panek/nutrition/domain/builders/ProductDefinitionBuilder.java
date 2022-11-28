package com.panek.nutrition.domain.builders;

import com.panek.nutrition.domain.Macronutrient;
import com.panek.nutrition.domain.ProductDefinition;

public class ProductDefinitionBuilder {

    private String id = "a-product-id";
    private String name = "a-product-name";
    private String barcode = "a-barcode";
    private int fatPer100g = 10;
    private int carbohydratePer100g = 20;
    private int proteinPer100g = 30;
    
    public static ProductDefinitionBuilder aProductDefinition() {
        return new ProductDefinitionBuilder();
    }
    
    public ProductDefinition build() {
        return new ProductDefinition(
                id,
                name,
                barcode,
                Macronutrient.fat(fatPer100g),
                Macronutrient.carbohydrate(carbohydratePer100g),
                Macronutrient.protein(proteinPer100g)
        );
    }

    public ProductDefinitionBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public ProductDefinitionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductDefinitionBuilder withBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public ProductDefinitionBuilder withFatPer100g(int fatPer100g) {
        this.fatPer100g = fatPer100g;
        return this;
    }

    public ProductDefinitionBuilder withCarbohydratePer100g(int carbohydratePer100g) {
        this.carbohydratePer100g = carbohydratePer100g;
        return this;
    }

    public ProductDefinitionBuilder withProteinPer100g(int proteinPer100g) {
        this.proteinPer100g = proteinPer100g;
        return this;
    }
}
