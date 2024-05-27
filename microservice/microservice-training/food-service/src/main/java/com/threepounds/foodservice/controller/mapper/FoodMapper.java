package com.threepounds.foodservice.controller.mapper;

import com.threepounds.foodservice.controller.dto.FoodDto;
import com.threepounds.foodservice.controller.resource.FoodResource;
import com.threepounds.foodservice.controller.resource.IngredientResource;
import com.threepounds.foodservice.data.entity.Food;
import com.threepounds.foodservice.util.S3Util;
import jakarta.inject.Inject;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public abstract class FoodMapper {

  private static final String S3_BUCKET_FOOD_FOLDER = "foods/";

  private static final String S3_BUCKET_INGREDIENT_FOLDER = "ingredient/";

  @Inject
  private IngredientMapper ingredientMapper;


  @Mapping(source = "ingredients", target = "ingredients", ignore = true)
  public abstract Food dtoToEntity(FoodDto foodDto);

  public abstract FoodResource entityToResource(Food food);


  public abstract List<FoodResource> listEntityToListResource(List<Food> foods);

  @AfterMapping
  void afterResourceMapping(Food entity, @MappingTarget FoodResource foodResource) {
    if (!CollectionUtils.isEmpty(entity.getPhotos())) {
      List<String> photosUrl = entity.getPhotos().stream().map(key ->
          S3Util.getPreSignedUrl("microservice-training",
              S3_BUCKET_FOOD_FOLDER + key.getKeys() + ".jpg")
      ).collect(Collectors.toList());
      foodResource.setPhotosName(photosUrl);
    }

    List<IngredientResource> ingredients = ingredientMapper.entityToResourceList(
        entity.getIngredients());

    foodResource.setIngredients(ingredients);

  }
}