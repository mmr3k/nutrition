package com.panek.nutrition.domain;

import java.util.UUID;

public interface ProductIdGenerator {

    String generate();

    class Default implements ProductIdGenerator {
        public String generate() {
            return UUID.randomUUID().toString();
        }
    }
}
