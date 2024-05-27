package com.threepounds.authservice.data.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.UUID;


@Data
@Entity(name = "users")
public class User implements UserDetails {

  @Id
  @GeneratedValue
  @Column
  private UUID id;

  @OneToMany
  private Set<Authority> authorities;

  private String password;
    @Column
  private String name;

  private String picture;

  @Column(unique = true)
  private String username;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean credentialsNonExpired;

  private String provider;

  private String providerId;

  private boolean enabled;


}
