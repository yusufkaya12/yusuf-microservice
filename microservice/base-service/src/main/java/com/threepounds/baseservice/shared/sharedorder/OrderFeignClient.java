package com.threepounds.baseservice.shared.sharedorder;

import com.threepounds.baseservice.common.ResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient("order-service")
public interface OrderFeignClient {
    @RequestMapping(value = SharedOrderEndpoint.ORDER_ID, method = RequestMethod.GET)
    ResponseEntity<ResponseModel<SharedOrder>> getOrder(@PathVariable UUID id);
}
