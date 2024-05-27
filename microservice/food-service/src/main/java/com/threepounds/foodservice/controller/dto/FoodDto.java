package com.threepounds.foodservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
  private UUID categoryId;
  private String name;
  private List<UUID> ingredients;
}
