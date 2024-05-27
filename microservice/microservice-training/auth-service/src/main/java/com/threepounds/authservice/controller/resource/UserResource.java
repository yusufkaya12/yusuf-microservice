package com.threepounds.authservice.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private UUID id;
    private String username;

    private String name;

    private String email;

    private String password;
}
