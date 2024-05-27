package com.threepounds.authservice.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity(name = "authorities")
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue
  private UUID id;

  public String authority;
}
