package com.panek.nutrition.domain;

import java.util.Optional;

public interface ProductDefinitionRepository {

    Optional<ProductDefinition> findById(String id);
    void save(ProductDefinition productDefinition);
}
