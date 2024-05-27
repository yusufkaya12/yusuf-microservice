package com.threepounds.baseservice.shared.sharedfood;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedIngredientEndpoint {
    static final String INGREDIENTS = "/ingredients";
    static final String INGREDIENTS_ID = "/ingredients/{id}";
}
