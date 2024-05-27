package com.threepounds.foodservice.Service;

import com.threepounds.foodservice.data.entity.Category;
import com.threepounds.foodservice.data.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public void delete(UUID id) {
    categoryRepository.deleteById(id);
  }

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> list() {
    return categoryRepository.findAll();
  }

  public Optional<Category> getById(UUID id) {
    return categoryRepository.findById(id);
  }

    public Page<Category> listByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return categoryRepository.findAll(pageable);
    }

}
