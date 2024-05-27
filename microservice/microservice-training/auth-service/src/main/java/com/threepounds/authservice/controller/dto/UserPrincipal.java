package com.threepounds.authservice.controller.dto;


import com.threepounds.authservice.data.entity.User;
import java.util.Map;

public class UserPrincipal {

    public static UserResponse create(User user, Map<String ,Object> attributes){
        return UserResponse.builder()
                .user(user)
                .attributes(attributes).build();
    }

}