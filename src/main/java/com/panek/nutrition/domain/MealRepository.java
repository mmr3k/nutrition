package com.panek.nutrition.domain;

import java.util.Optional;

public interface MealRepository {
    void save(Meal meal);
    Optional<Meal> findById(String id);
}
