package com.threepounds.foodservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "food_photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    @Column
    @GeneratedValue
    private UUID id;

    @Column
    private String keys;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;
}