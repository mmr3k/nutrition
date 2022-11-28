package com.panek.nutrition.domain;

import java.util.Objects;

public sealed class Macronutrient {

    private final int amount;
    private final int caloriesMultiplier;

    private Macronutrient(int amount, int caloriesMultiplier) {
        if (amount < 0 || amount > 100) {
            throw new NutritionException.InvalidArgumentException("Macro nutrient amount should be in range <0, 100>. Provided amount: " + amount);
        }
        this.amount = amount;
        this.caloriesMultiplier = caloriesMultiplier;
    }

    public int getCalories() {
        return amount * caloriesMultiplier;
    }

    public int getAmount() {
        return amount;
    }

    public static Macronutrient.Fat fat(int amount) {
        return new Fat(amount);
    }

    public static Macronutrient.Carbohydrate carbohydrate(int amount) {
        return new Carbohydrate(amount);
    }

    public static Macronutrient.Protein protein(int amount) {
        return new Protein(amount);
    }

    public final static class Protein extends Macronutrient {

        private Protein(int amount) {
            super(amount, 4);
        }
    }

    public final static class Carbohydrate extends Macronutrient {

        private Carbohydrate(int amount) {
            super(amount, 4);
        }
    }

    public final static class Fat extends Macronutrient {

        private Fat(int amount) {
            super(amount, 7);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Macronutrient that = (Macronutrient) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
