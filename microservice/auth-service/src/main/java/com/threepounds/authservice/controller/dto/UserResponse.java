package com.threepounds.authservice.controller.dto;


import com.threepounds.authservice.data.entity.User;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
    private User user;
    private Map<String,Object> attributes;
}