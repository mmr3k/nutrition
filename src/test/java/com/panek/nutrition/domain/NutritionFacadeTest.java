package com.panek.nutrition.domain;

import com.panek.nutrition.domain.assertions.MealAssertions;
import com.panek.nutrition.domain.assertions.ProductDefinitionAssertions;
import com.panek.nutrition.domain.builders.ProductDefinitionBuilder;
import com.panek.nutrition.domain.testdoubles.FakeMealRepository;
import com.panek.nutrition.domain.testdoubles.FakeProductDefinitionRepository;
import com.panek.nutrition.domain.testdoubles.MockMealIdGenerator;
import com.panek.nutrition.domain.testdoubles.MockProductIdGenerator;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.panek.nutrition.domain.builders.ProductDefinitionBuilder.aProductDefinition;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NutritionFacadeTest {

    private final FakeMealRepository fakeMealRepository = new FakeMealRepository();
    private final FakeProductDefinitionRepository fakeProductDefinitionRepository = new FakeProductDefinitionRepository();
    private final MockProductIdGenerator mockProductIdGenerator = new MockProductIdGenerator();
    private final MockMealIdGenerator mockMealIdGenerator = new MockMealIdGenerator();

    private final NutritionFacade nutritionFacade = Config.nutritionFacade(
            fakeMealRepository,
            mockMealIdGenerator,
            fakeProductDefinitionRepository,
            mockProductIdGenerator
    );

    @BeforeEach
    void setup() {
        mockMealIdGenerator.alwaysReturns("fake-meal-id");
        mockProductIdGenerator.alwaysReturns("fake-product-id");
    }

    @Test
    void shouldAddNewMeal() {
        // given
        thereIs(aProductDefinition().withId(TestData.PRODUCT_ID_1).withName(TestData.PRODUCT_NAME_1).build());
        thereIs(aProductDefinition().withId(TestData.PRODUCT_ID_2).withName(TestData.PRODUCT_NAME_2).build());

        // when
        var createdMeal = nutritionFacade.createMeal(new CreateMealCommand(
                "meal-name",
                List.of(
                        new CreateMealCommand.ProductWithWeight(TestData.PRODUCT_ID_1,  50),
                        new CreateMealCommand.ProductWithWeight(TestData.PRODUCT_ID_2,  80)
                )
        ));

        // then
        var meal = fakeMealRepository.findById("fake-meal-id");
        assertThat(meal).isPresent();
        assertThat(meal.get()).isEqualTo(createdMeal);

        MealAssertions.assertThat(meal.get())
                .hasId("fake-meal-id")
                .hasName("meal-name")
                .hasProductUsagesOfSize(2)
                .hasProductUsageForProductIdThat(TestData.PRODUCT_ID_1)
                    .hasWeight(50)
                .hasProductUsageForProductIdThat(TestData.PRODUCT_ID_2)
                    .hasWeight(80);
    }

    @Test
    void shouldThrowForProductDefinitionNotFoundForCreateMeal() {
        // given
        thereIs(aProductDefinition().withId(TestData.PRODUCT_ID_1).withName(TestData.PRODUCT_NAME_1).build());

        // when
        ThrowableAssert.ThrowingCallable whenBlock = () -> nutritionFacade.createMeal(new CreateMealCommand(
                "meal-name",
                List.of(
                        new CreateMealCommand.ProductWithWeight(TestData.PRODUCT_ID_1,  50),
                        new CreateMealCommand.ProductWithWeight(TestData.PRODUCT_ID_2,  80)
                )
        ));

        // then
        assertThatThrownBy(whenBlock).isInstanceOf(NutritionException.ProductDefinitionNotFound.class);
    }

    @Test
    void shouldCreateProductDefinition() {
        // when
        var createdProduct = nutritionFacade.createProduct(new CreateProductCommand(
                "product-name",
                "a-barcode",
                50,
                20,
                30
        ));

        // then
        var foundProductDefinition = fakeProductDefinitionRepository.findById("fake-product-id");
        assertThat(foundProductDefinition).isPresent();
        assertThat(foundProductDefinition.get()).isEqualTo(createdProduct);

        ProductDefinitionAssertions.assertThat(foundProductDefinition.get())
                .hasId("fake-product-id")
                .hasName("product-name")
                .hasBarcode("a-barcode")
                .hasFat(50)
                .hasCarbohydrate(20)
                .hasProtein(30);
    }

    private void thereIs(ProductDefinition productDefinition) {
        fakeProductDefinitionRepository.save(productDefinition);
    }

    static class TestData {
        final static String PRODUCT_ID_1 = "product-id-1";
        final static String PRODUCT_NAME_1 = "product-name-1";
        final static String PRODUCT_ID_2 = "product-id-2";
        final static String PRODUCT_NAME_2 = "product-name-2";
    }
}
