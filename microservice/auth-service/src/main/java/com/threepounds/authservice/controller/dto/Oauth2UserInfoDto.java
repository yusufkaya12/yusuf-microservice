package com.threepounds.authservice.controller.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Oauth2UserInfoDto {
    private String id;
    private String name;
    private String email;
    private String picture;
}
