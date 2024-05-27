package com.threepounds.foodservice.controller;

import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.foodservice.Service.CategoryService;
import com.threepounds.foodservice.Service.FoodService;
import com.threepounds.foodservice.Service.IngredientService;
import com.threepounds.foodservice.Service.PhotoService;
import com.threepounds.foodservice.controller.dto.FoodDto;
import com.threepounds.foodservice.controller.mapper.FoodMapper;
import com.threepounds.foodservice.controller.resource.FoodResource;
import com.threepounds.foodservice.controller.response.ResponseModel;
import com.threepounds.foodservice.data.entity.Category;
import com.threepounds.foodservice.data.entity.Food;
import com.threepounds.foodservice.data.entity.Ingredient;
import com.threepounds.foodservice.data.entity.Photo;
import com.threepounds.foodservice.util.S3Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foods")
@Slf4j
public class FoodController {
  private static final String S3_BUCKET_FOOD_FOLDER =  "foods/";

  private final IngredientService ingredientService;
  private final PhotoService photoService;
  private final FoodService foodService;
  private final FoodMapper foodMapper;
  private final CategoryService categoryService;

  public FoodController(IngredientService ingredientService, PhotoService photoService, FoodService foodService,
                        FoodMapper foodMapper, CategoryService categoryService) {
    this.ingredientService = ingredientService;
      this.photoService = photoService;
      this.foodService = foodService;
    this.foodMapper = foodMapper;
      this.categoryService = categoryService;
  }

    @PostMapping("/")
  public ResponseModel<FoodResource> create(@RequestBody FoodDto foodDto) {
    Food saveToFood = foodMapper.dtoToEntity(foodDto);
    List<Ingredient> ingredients = ingredientService.listById(foodDto.getIngredients());
    System.out.println(ingredients);
    Category category=categoryService.getById(foodDto.getCategoryId()).orElseThrow(
            ()->new NotFoundException("Category not found"));
    saveToFood.setCategory(category);
    saveToFood.setIngredients(ingredients);
    Food savedFood = foodService.save(saveToFood);
    FoodResource foodResource = foodMapper.entityToResource(savedFood);
    return new ResponseModel<>(HttpStatus.OK.value(), foodResource, null);
  }

  @DeleteMapping("/{id}")
  public ResponseModel<String> remove(@PathVariable UUID id) {
    foodService.delete(id);
    return new ResponseModel<>(HttpStatus.OK.value(), "Food removed", null);
  }

    @GetMapping("/")
  public ResponseModel<List<FoodResource>> getAll() {
    List<Food> foods = foodService.list();
    List<FoodResource> foodResources = foodMapper.listEntityToListResource(foods);
    return new ResponseModel<>(HttpStatus.OK.value(), foodResources, null);
  }

  @GetMapping("/{id}")
  public ResponseModel<FoodResource> getOne(@PathVariable UUID id) {
    Food food = foodService.getById(id).orElseThrow(() -> new NotFoundException("Food not found"));
    FoodResource foodResource = foodMapper.entityToResource(food);
    return new ResponseModel<>(HttpStatus.OK.value(), foodResource, null);
  }

  @PutMapping("/{id}")
  public ResponseModel<FoodResource> update(@PathVariable UUID id, @RequestBody FoodDto foodDto) {
    Food food = foodService.getById(id).orElseThrow(() -> new NotFoundException("Food Not found"));
    Food mappedFood = foodMapper.dtoToEntity(foodDto);
    mappedFood.setId(food.getId());
    Food update = foodService.save(mappedFood);
    FoodResource foodResource = foodMapper.entityToResource(update);
    return new ResponseModel<>(HttpStatus.OK.value(), foodResource, null);
  }
  @PutMapping("/photos")
  public ResponseModel<String> uploadPhotos(@RequestParam("files") MultipartFile[] files,
                                            @RequestParam("id") UUID foodId) {
    Food existingFood=foodService.getById(foodId)
        .orElseThrow(()->new NotFoundException("Food Not Found"));
    List<String> fileKeys = new ArrayList<>();
    Arrays.asList(files).stream().forEach(file -> {

      UUID s3id=UUID.randomUUID();


      try {
        S3Util.uploadObject("microservice-training", S3_BUCKET_FOOD_FOLDER + s3id + ".jpg", file.getInputStream());
      } catch (IOException e) {
        log.error("An error occured during file upload", e);
      }

      fileKeys.add(s3id.toString());

    });


    //foodService.save(existingFood);
    List<Photo> photos = new ArrayList<>();
    for(String key:fileKeys){
      Photo photo = new Photo();
      photo.setFood(existingFood);
      photo.setKeys(key);
      photoService.save(photo);
      photos.add(photo);
    }
    existingFood.setPhotos(photos);
    foodService.save(existingFood);


    return new ResponseModel<>(HttpStatus.OK.value(), "Photos Uploaded", null);
  }

  @GetMapping("/page")
  public ResponseModel<List<FoodResource>> listByPage(@RequestParam int pageNumber, @RequestParam int pageSize) {
    Page<Food> food = foodService.listByPage(pageNumber, pageSize);
    List<FoodResource> foodResources = foodMapper.listEntityToListResource(food.toList());
    return new ResponseModel<>(HttpStatus.OK.value(), foodResources, null, food.getTotalPages(),
            (int) food.getTotalElements());

  }

  @GetMapping("/category/{id}")
  public ResponseModel<List<FoodResource>> FoodsByCategory(@PathVariable UUID id) {
    Category category = categoryService.getById(id).orElseThrow(
            () -> new NotFoundException("Category Not Found"));
    List<Food> foods = foodService.getFoodsByCategory(category);
    List<FoodResource> foodResources = foodMapper.listEntityToListResource(foods);
    return new ResponseModel<>(HttpStatus.OK.value(), foodResources, null);

  }

    @GetMapping("/foods_ids")
    public ResponseModel<List<UUID>> getFoodsIds() {
        List<Food> foods = foodService.list();
        List<UUID> foodIds = foods.stream().map(s -> s.getId()).collect(Collectors.toList());
        return new ResponseModel<>(HttpStatus.OK.value(), foodIds, null);
  }
}
