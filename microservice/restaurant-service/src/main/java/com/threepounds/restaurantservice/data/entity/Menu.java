package com.threepounds.restaurantservice.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "menus")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Menu {
    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @Column
    private String name;


    @ElementCollection
    @CollectionTable(name = "food_menu_id",
            joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name = "food_id")
    private List<UUID> foodId;

}
