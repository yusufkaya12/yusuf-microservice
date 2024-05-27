package com.threepounds.foodservice.controller.mapper;

import com.threepounds.foodservice.controller.dto.CategoryDto;
import com.threepounds.foodservice.controller.resource.CategoryResource;
import com.threepounds.foodservice.data.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

  Category dtoToEntity(CategoryDto categoryDto);

  CategoryResource entityToResource(Category category);

  List<CategoryResource> listEntityToResource(List<Category> categories);
}
