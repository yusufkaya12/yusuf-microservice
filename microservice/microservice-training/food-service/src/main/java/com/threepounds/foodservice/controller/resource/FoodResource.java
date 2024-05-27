package com.threepounds.foodservice.controller.resource;

import com.threepounds.foodservice.data.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResource {
  private UUID id;
  private String name;
  private List<String> photosName;
  private Category category;
  private List<IngredientResource> ingredients;


}
