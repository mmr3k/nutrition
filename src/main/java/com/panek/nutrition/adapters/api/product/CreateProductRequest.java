package com.panek.nutrition.adapters.api.product;

public class CreateProductRequest {
    private final String name;
    private final String barcode;
    private final int fatPer100g;
    private final int carbohydratesPer100g;
    private final int proteinsPer100g;

    public CreateProductRequest(String name, String barcode, int fatPer100g, int carbohydratesPer100g, int proteinsPer100g) {
        this.name = name;
        this.barcode = barcode;
        this.fatPer100g = fatPer100g;
        this.carbohydratesPer100g = carbohydratesPer100g;
        this.proteinsPer100g = proteinsPer100g;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getFatPer100g() {
        return fatPer100g;
    }

    public int getCarbohydratesPer100g() {
        return carbohydratesPer100g;
    }

    public int getProteinsPer100g() {
        return proteinsPer100g;
    }
}
