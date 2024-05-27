package com.threepounds.orderservice.controller.resource;

import com.threepounds.baseservice.shared.sharedfood.SharedFood;
import com.threepounds.baseservice.shared.sharedrestaurant.SharedRestaurant;
import com.threepounds.baseservice.shared.shareduser.SharedUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResource {
    private SharedRestaurant sharedRestaurant;
    private List<SharedFood> sharedFood;
    private SharedUser sharedUser;
    private String note;
    private ZonedDateTime createdDate;
    private String paymentType;
    private BigDecimal price;
}
