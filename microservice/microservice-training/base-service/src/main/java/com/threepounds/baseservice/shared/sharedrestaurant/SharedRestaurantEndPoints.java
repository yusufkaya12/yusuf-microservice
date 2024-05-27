package com.threepounds.baseservice.shared.sharedrestaurant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedRestaurantEndPoints {
    static final String RESTAURANTS = "/restaurant";
    static final String RESTAURANT_ID = "/restaurant/{id}";
}
