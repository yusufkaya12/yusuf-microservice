package com.threepounds.authservice.controller.dto;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {
  private String username;

  private String name;

  private String email;

  private String password;
  private List<UUID> roles;
}
