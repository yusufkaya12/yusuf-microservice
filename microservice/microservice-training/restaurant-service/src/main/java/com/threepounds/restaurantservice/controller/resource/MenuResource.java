package com.threepounds.restaurantservice.controller.resource;


import com.threepounds.baseservice.shared.sharedfood.SharedFood;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResource {
    private UUID id;
    private String name;
    private List<SharedFood> sharedFoods;

}
