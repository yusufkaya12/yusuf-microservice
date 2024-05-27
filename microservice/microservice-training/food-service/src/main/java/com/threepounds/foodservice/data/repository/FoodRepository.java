package com.threepounds.foodservice.data.repository;

import com.threepounds.foodservice.data.entity.Category;
import com.threepounds.foodservice.data.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
     List<Food> findByCategory(Category category);
}
