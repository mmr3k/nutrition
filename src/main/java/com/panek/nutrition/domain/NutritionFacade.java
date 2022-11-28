package com.panek.nutrition.domain;

import java.util.Optional;
import java.util.stream.Collectors;

public class NutritionFacade {

    private final ProductDefinitionRepository productRepository;
    private final ProductIdGenerator productIdGenerator;
    private final MealIdGenerator mealIdGenerator;
    private final MealRepository mealRepository;

    public NutritionFacade(
            ProductDefinitionRepository productRepository,
            ProductIdGenerator productIdGenerator,
            MealIdGenerator mealIdGenerator,
            MealRepository mealRepository
    ) {
        this.productRepository = productRepository;
        this.productIdGenerator = productIdGenerator;
        this.mealIdGenerator = mealIdGenerator;
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(CreateMealCommand command) {
        var productsUsages = command.products()
                .stream()
                .map(this::toProductUsage)
                .collect(Collectors.toList());

        var meal = new Meal(mealIdGenerator.generate(), command.name(), productsUsages);
        mealRepository.save(meal);
        return meal;
    }

    public ProductDefinition createProduct(CreateProductCommand command) {
        var productDefinition = toProductDefinition(command);
        productRepository.save(productDefinition);
        return productDefinition;
    }

    public Optional<ProductDefinition> findProduct(String id) {
        return productRepository.findById(id);
    }

    private ProductUsage toProductUsage(CreateMealCommand.ProductWithWeight productWithWeight) {
        var productDefinition = productRepository.findById(productWithWeight.productId());
        if (productDefinition.isEmpty()) {
            throw new NutritionException.ProductDefinitionNotFound(productWithWeight.productId());
        }
        return new ProductUsage(productDefinition.get(), productWithWeight.weight());
    }

    private ProductDefinition toProductDefinition(CreateProductCommand command) {
        return new ProductDefinition(
                productIdGenerator.generate(),
                command.name(),
                command.barcode(),
                Macronutrient.fat(command.fatPer100g()),
                Macronutrient.carbohydrate(command.carbohydratesPer100g()),
                Macronutrient.protein(command.proteinsPer100g())
        );
    }
}
