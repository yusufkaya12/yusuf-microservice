package com.threepounds.foodservice.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientResource {
  private UUID id;
  private String name;
  private String photoUrl;
}
