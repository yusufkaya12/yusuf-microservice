package com.threepounds.foodservice.controller;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.foodservice.Service.IngredientService;
import com.threepounds.foodservice.controller.dto.IngredientDto;
import com.threepounds.foodservice.controller.mapper.IngredientMapper;
import com.threepounds.foodservice.controller.resource.IngredientResource;
import com.threepounds.foodservice.controller.response.ResponseModel;
import com.threepounds.foodservice.data.entity.Ingredient;
import com.threepounds.foodservice.util.S3Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredient")
public class IngredientController {

  private final IngredientService ingredientService;
  private final IngredientMapper ingredientMapper;

  private static final String S3_BUCKET_INGREDIENT_FOLDER = "ingredient/";

    @PostMapping("/")
  public ResponseModel<IngredientResource> create(@RequestBody IngredientDto ingredientDto) {
    Ingredient saveToIngredient = ingredientMapper.dtoToEntity(ingredientDto);
    Ingredient savedIngredient = ingredientService.save(saveToIngredient);
    IngredientResource ingredientResource = ingredientMapper.entityToResource(savedIngredient);
    return new ResponseModel<>(HttpStatus.OK.value(), ingredientResource, null);

  }

  @GetMapping("/{id}")
  public ResponseModel<IngredientResource> getIngredient(@PathVariable UUID id) {
    Ingredient ingredient = ingredientService.getById(id)
        .orElseThrow(() -> new NotFoundException("Ingredient not found"));
    IngredientResource ingredientResource = ingredientMapper.entityToResource(ingredient);
    return new ResponseModel<>(HttpStatus.OK.value(), ingredientResource, null);
  }

    @GetMapping("/")
  public ResponseModel<List<IngredientResource>> getIngredients() {
    List<Ingredient> ingredients = ingredientService.list();
    List<IngredientResource> ingredientResources = ingredientMapper.entityToResourceList(
        ingredients);
    return new ResponseModel<>(HttpStatus.OK.value(), ingredientResources, null);
  }

  @PutMapping("/{id}")
  public ResponseModel<IngredientResource> update(@RequestBody IngredientDto ingredientDto,
      @PathVariable UUID id) {
    Ingredient ingredient = ingredientService.getById(id)
        .orElseThrow(() -> new NotFoundException("Ingredient not found"));
    Ingredient mappedIngredient = ingredientMapper.dtoToEntity(ingredientDto);
    mappedIngredient.setId(ingredient.getId());
    Ingredient update = ingredientService.save(mappedIngredient);
    IngredientResource ingredientResource = ingredientMapper.entityToResource(update);
    return new ResponseModel<>(HttpStatus.OK.value(), ingredientResource, null);
  }

  @DeleteMapping("/{id}")
  public ResponseModel<String> remove(@PathVariable UUID id) {
    ingredientService.delete(id);
    return new ResponseModel<>(HttpStatus.OK.value(), "Ingredient removed", null);
  }

  @PutMapping("/photos")
  public ResponseModel<String> uploadPhotos(@RequestParam("files") MultipartFile file,
      @RequestParam("id") UUID ingredientId) {
      Ingredient ingredient=ingredientService.getById(ingredientId).orElseThrow((

      )->new NotFoundException("Ingredient not found"));
      UUID s3id = UUID.randomUUID();
      ingredient.setPhotoS3Key(s3id.toString());

    try {
      S3Util.uploadObject("microservice-training", S3_BUCKET_INGREDIENT_FOLDER + s3id + ".jpg",
          file.getInputStream());
    } catch (IOException e) {
      log.error("An error occured during file upload", e);
    }
     ingredientService.save(ingredient);
    return new ResponseModel<>(HttpStatus.OK.value(), "Photo uploaded", null);
  }

    @GetMapping("/page")
    public ResponseModel<List<IngredientResource>> listByPage(@RequestParam int pageNumber,
                                                              @RequestParam int pageSize) {
        Page<Ingredient> ingredientPage = ingredientService.listById(pageNumber, pageSize);
        List<IngredientResource> ingredientResources = ingredientMapper.entityToResourceList(ingredientPage.toList());

        return new ResponseModel<>(HttpStatus.OK.value(), ingredientResources, null,
                (int) ingredientPage.getTotalElements(), ingredientPage.getTotalPages());
    }

}
