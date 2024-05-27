package com.threepounds.foodservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "foods")
public class Food {

  @Column
  private String name;
  @Id
  @GeneratedValue
  @Column
  private UUID id;
    @Column
    private BigDecimal price;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "food_ingredient",
      joinColumns = @JoinColumn(name = "food_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  private List<Ingredient> ingredients;

  @OneToMany
  private List<Photo> photos;
  @OneToOne
  @JoinColumn(name = "category_id")
  private Category category;
}
