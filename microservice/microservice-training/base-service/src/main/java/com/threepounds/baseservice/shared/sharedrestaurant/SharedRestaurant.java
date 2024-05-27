package com.threepounds.baseservice.shared.sharedrestaurant;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class SharedRestaurant implements Serializable {
    private UUID id;
    private UUID cityId;
    private UUID countyId;
    private UUID streetId;
    private String address;
    private String name;
}
