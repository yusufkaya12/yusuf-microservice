package com.threepounds.restaurantservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private String name;
    private String address;
    private UUID cityId;
    private UUID countyId;
    private UUID streetId;
}
