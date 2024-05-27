package com.threepounds.foodservice.controller;

import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.foodservice.Service.CategoryService;
import com.threepounds.foodservice.Service.FoodService;
import com.threepounds.foodservice.controller.dto.CategoryDto;
import com.threepounds.foodservice.controller.mapper.CategoryMapper;
import com.threepounds.foodservice.controller.resource.CategoryResource;
import com.threepounds.foodservice.controller.response.ResponseModel;
import com.threepounds.foodservice.data.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final FoodService foodService;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper, FoodService foodService) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.foodService = foodService;
    }

    @PostMapping("/")
    public ResponseModel<CategoryResource> create(@RequestBody CategoryDto categoryDto){
        Category categoryToSave=categoryMapper.dtoToEntity(categoryDto);
        Category category=categoryService.save(categoryToSave);
        CategoryResource categoryResource=categoryMapper.entityToResource(category);
        return new ResponseModel<>(HttpStatus.OK.value(), categoryResource,null);
    }
    @DeleteMapping("/{id}")
    public ResponseModel<String> remove(@PathVariable UUID id){
        categoryService.delete(id);
        return new ResponseModel<>(HttpStatus.OK.value(), "Category Removed",null);
    }

    @GetMapping("/")
    public ResponseModel<List<CategoryResource>> getAll(){
        List<Category> categories=categoryService.list();
        List<CategoryResource> categoryResources=categoryMapper.listEntityToResource(categories);
        return new ResponseModel<>(HttpStatus.OK.value(), categoryResources,null);
    }
    @GetMapping("/{id}")
    public ResponseModel<CategoryResource> getOneCategory(@PathVariable UUID id){
        Category category=categoryService.getById(id).orElseThrow((
                        )->new NotFoundException("Category not found"));
        CategoryResource categoryResource=categoryMapper.entityToResource(category);
        return new ResponseModel<>(HttpStatus.OK.value(), categoryResource,null);
    }

    @GetMapping("/page")
    public ResponseModel<List<CategoryResource>> listByPage(@RequestParam int pageNumber, @RequestParam int pageSize) {

        Page<Category> categories = categoryService.listByPage(pageNumber, pageSize);

        List<CategoryResource> categoryResources = categoryMapper.listEntityToResource(
                categories.toList());

        return new ResponseModel<>(HttpStatus.OK.value(), categoryResources, null,
                (int) categories.getTotalElements(), categories.getTotalPages());
    }

}
