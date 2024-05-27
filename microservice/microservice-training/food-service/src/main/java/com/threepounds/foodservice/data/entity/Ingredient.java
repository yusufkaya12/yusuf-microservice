package com.threepounds.foodservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "ingredients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    @Column
    private String name;
    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @Column
    private String photoS3Key;


}
