package com.threepounds.orderservice.service;

import com.threepounds.baseservice.stream.OrderCreatedMessage;
import com.threepounds.orderservice.data.entity.Order;
import com.threepounds.orderservice.data.repo.OrderRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final RabbitTemplate rabbitTemplate;
    private final OrderRepository orderRepository;

    public OrderService(RabbitTemplate rabbitTemplate, OrderRepository orderRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        Order save = orderRepository.save(order);
        OrderCreatedMessage message = new OrderCreatedMessage();
        message.setOrderId(order.getId());
        rabbitTemplate.convertAndSend("","order",message);
        return save;
    }

    public void list() {
        orderRepository.findAll();
    }

    public Optional<Order> getById(UUID id) {
        return orderRepository.findById(id);
    }
}
