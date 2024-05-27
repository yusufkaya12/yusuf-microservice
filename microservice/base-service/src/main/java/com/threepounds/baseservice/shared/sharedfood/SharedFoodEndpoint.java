package com.threepounds.baseservice.shared.sharedfood;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedFoodEndpoint {
    static final String FOODS="/foods";
    static final String FOODS_ID="/foods/{id}";
}
