package com.threepounds.orderservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID restaurantId;
    private UUID userId;
    private String note;
    private List<UUID> foodId;
    private ZonedDateTime createdDate;
    private String paymentType;
    private BigDecimal price;
}
