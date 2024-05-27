package com.threepounds.baseservice.shared.sharedorder;

import com.threepounds.baseservice.common.ResponseModel;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class SharedOrderService {
    private final OrderFeignClient orderFeignClient;

    public ResponseModel<SharedOrder> getOrderById(UUID id) {
        try {

            return orderFeignClient.getOrder(id).getBody();


        } catch (FeignException fe) {
            if (fe.status() != HttpStatus.NOT_FOUND.value()) {
                log.error("Unable to get user order", fe);
            }
            return null;
        }
    }
}
