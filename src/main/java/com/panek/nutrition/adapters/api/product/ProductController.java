package com.panek.nutrition.adapters.api.product;

import com.panek.nutrition.domain.CreateProductCommand;
import com.panek.nutrition.domain.NutritionFacade;
import com.panek.nutrition.domain.ProductDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    private final NutritionFacade nutritionFacade;

    public ProductController(NutritionFacade nutritionFacade) {
        this.nutritionFacade = nutritionFacade;
    }

    @PostMapping
    public ResponseEntity<String> createProductDefinition(@RequestBody CreateProductRequest request) {
        var domainCommand = new CreateProductCommand(
                request.getName(),
                request.getBarcode(),
                request.getFatPer100g(),
                request.getCarbohydratesPer100g(),
                request.getProteinsPer100g()
        );

        var product = nutritionFacade.createProduct(domainCommand);
        return ResponseEntity.ok(product.id());
    }

    @GetMapping("{id}")
    // TODO change to dedicated response class
    public ResponseEntity<ProductDefinition> getProductDefinition(@PathVariable("id") String id) {
        return ResponseEntity.of(nutritionFacade.findProduct(id));
    }
}
