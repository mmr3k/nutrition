package com.panek.nutrition.domain.testdoubles;

import com.panek.nutrition.domain.Meal;
import com.panek.nutrition.domain.MealRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeMealRepository implements MealRepository {

    private final Map<String, Meal> values = new HashMap<>();

    @Override
    public void save(Meal meal) {
        values.put(meal.id(), meal);
    }

    @Override
    public Optional<Meal> findById(String id) {
        return Optional.ofNullable(values.get(id));
    }
}
