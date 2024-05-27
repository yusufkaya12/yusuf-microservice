package com.threepounds.foodservice.controller.mapper;

import com.threepounds.foodservice.controller.dto.IngredientDto;
import com.threepounds.foodservice.controller.resource.IngredientResource;
import com.threepounds.foodservice.data.entity.Ingredient;
import com.threepounds.foodservice.util.S3Util;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class IngredientMapper {

  private static final String S3_BUCKET_INGREDIENT_FOLDER = "ingredient/";

  public abstract Ingredient dtoToEntity(IngredientDto ingredientDto);

  public abstract IngredientResource entityToResource(Ingredient ingredient);

  public abstract List<IngredientResource> entityToResourceList(List<Ingredient> ingredientList);

  @AfterMapping
  void afterResourceMapping (Ingredient ingredient, @MappingTarget IngredientResource ingredientResource){
    String ingredientUrl= S3Util.getPreSignedUrl("microservice-training",S3_BUCKET_INGREDIENT_FOLDER+ingredient.getPhotoS3Key()+ ".jpg");
    ingredientResource.setPhotoUrl(ingredientUrl);
  }
}
