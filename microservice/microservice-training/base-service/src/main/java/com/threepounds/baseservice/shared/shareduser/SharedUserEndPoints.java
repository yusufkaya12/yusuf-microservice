package com.threepounds.baseservice.shared.shareduser;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SharedUserEndPoints {
    static final String USER_ID = "/user/{id}";
    static final String USERS = "/user/list";

}
