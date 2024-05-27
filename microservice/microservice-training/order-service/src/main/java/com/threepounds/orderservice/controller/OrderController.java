package com.threepounds.orderservice.controller;

import com.threepounds.baseservice.common.ResponseModel;
import com.threepounds.baseservice.common.exceptions.NotFoundException;
import com.threepounds.baseservice.shared.shareduser.SharedUserService;
import com.threepounds.orderservice.controller.dto.OrderDto;
import com.threepounds.orderservice.controller.mapper.OrderMapper;
import com.threepounds.orderservice.controller.resource.OrderResource;
import com.threepounds.orderservice.data.entity.Order;
import com.threepounds.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final OrderService orderService;
    private final SharedUserService sharedUserService;


    public OrderController(OrderMapper orderMapper, OrderService orderService, SharedUserService sharedUserService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;


        this.sharedUserService = sharedUserService;
    }

    @PostMapping("/")
    public ResponseModel<OrderResource> create(@RequestBody OrderDto orderDto) {
        Order saveToOrder = orderMapper.dtoToEntity(orderDto);
        saveToOrder.setFoodId(orderDto.getFoodId());
        orderService.save(saveToOrder);
        OrderResource orderResource = orderMapper.entityToResource(saveToOrder);
        return new ResponseModel<>(HttpStatus.OK.value(), orderResource, null);
    }

    @GetMapping("/{id}")
    public ResponseModel<OrderResource> getOneOrder(@PathVariable UUID id) {
        Order order = orderService.getById(id).orElseThrow(() -> new NotFoundException("Order Not Found"));
        OrderResource orderResource = orderMapper.entityToResource(order);
        return new ResponseModel<>(HttpStatus.OK.value(), orderResource, null);
    }

}
