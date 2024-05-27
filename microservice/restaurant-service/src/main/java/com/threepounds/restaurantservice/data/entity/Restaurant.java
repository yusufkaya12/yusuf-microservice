package com.threepounds.restaurantservice.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Column
    private UUID streetId;
    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private UUID cityId;
    @Column
    private UUID countyId;


}
