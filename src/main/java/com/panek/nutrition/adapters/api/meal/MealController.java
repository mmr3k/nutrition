package com.panek.nutrition.adapters.api.meal;

import com.panek.nutrition.domain.NutritionFacade;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealController {

    private final NutritionFacade nutritionFacade;

    public MealController(NutritionFacade nutritionFacade) {
        this.nutritionFacade = nutritionFacade;
    }
}
