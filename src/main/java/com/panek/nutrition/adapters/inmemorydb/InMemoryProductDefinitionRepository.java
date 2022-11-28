package com.panek.nutrition.adapters.inmemorydb;

import com.panek.nutrition.domain.ProductDefinition;
import com.panek.nutrition.domain.ProductDefinitionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductDefinitionRepository implements ProductDefinitionRepository {

    private final Map<String, ProductDefinition> values = new HashMap<>();

    @Override
    public Optional<ProductDefinition> findById(String id) {
        return Optional.ofNullable(values.get(id));
    }

    @Override
    public void save(ProductDefinition productDefinition) {
        values.put(productDefinition.id(), productDefinition);
    }
}
