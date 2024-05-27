package com.threepounds.baseservice.shared.sharedorder;

import com.threepounds.baseservice.shared.sharedfood.SharedFood;
import com.threepounds.baseservice.shared.sharedrestaurant.SharedRestaurant;
import com.threepounds.baseservice.shared.shareduser.SharedUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class SharedOrder {
    private SharedRestaurant sharedRestaurant;
    private List<SharedFood> sharedFood;
    private SharedUser sharedUser;
    private String note;
    private BigDecimal price;
    private ZonedDateTime createdDate;
    private String paymentType;

}
