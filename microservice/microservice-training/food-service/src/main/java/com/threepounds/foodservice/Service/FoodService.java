package com.threepounds.foodservice.Service;

import com.threepounds.foodservice.data.entity.Category;
import com.threepounds.foodservice.data.entity.Food;
import com.threepounds.foodservice.data.repository.FoodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {

  private final FoodRepository foodRepository;

  public FoodService(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public Food save(Food food) {
    return foodRepository.save(food);
  }

  public void delete(UUID id) {
    foodRepository.deleteById(id);
  }

  public List<Food> list() {
    return foodRepository.findAll();
  }

  public Optional<Food> getById(UUID id) {
    return foodRepository.findById(id);
  }

  public Page<Food> listByPage(int pageNumber, int pageSize) {
    Pageable pageable = PageRequest.of(pageNumber, pageSize);
    return foodRepository.findAll(pageable);
  }

  public List<Food> getFoodsByCategory(Category category) {
    return foodRepository.findByCategory(category);
  }

}
