package com.threepounds.orderservice.data.entity;

import com.threepounds.orderservice.data.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column
    @GeneratedValue
    private UUID id;
    @Column
    private UUID userId;
    @Column
    private UUID restaurantId;
    @Column
    private String note;
    @Column
    private BigDecimal price;
    @Column
    @CreationTimestamp
    private ZonedDateTime createdDate;
    @ElementCollection
    @CollectionTable(name = "order_foods",
            joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "food_id")
    private List<UUID> foodId;
    @Column
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;


}
