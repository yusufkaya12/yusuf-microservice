package com.threepounds.baseservice.shared.sharedfood;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedCategoryEndpoints {
    static final String CATEGORIES = "/categories";
    static final String CATEGORIES_ID = "/categories/{id}";

}
