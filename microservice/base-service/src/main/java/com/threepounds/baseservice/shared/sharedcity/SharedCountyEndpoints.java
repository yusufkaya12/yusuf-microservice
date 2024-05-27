package com.threepounds.baseservice.shared.sharedcity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedCountyEndpoints {

    static final String COUNTIES="/counties";
    static final String COUNTIES_ID="/counties/{id}";
}
