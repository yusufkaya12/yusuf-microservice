package com.threepounds.restaurantservice.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResource {
    private UUID id;
    private UUID cityId;
    private UUID countyId;
    private UUID streetId;
    private String address;
    private String name;
}
