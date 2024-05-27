package com.threepounds.baseservice.shared.sharedcity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedStreetEndpoints {
    static final String STREETS="/streets";
    static final String STREET_ID="/streets/{id}";
}
