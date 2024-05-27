package com.threepounds.baseservice.shared.sharedorder;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedOrderEndpoint {
    static final String ORDER_ID = "/orders/{id}";
}
