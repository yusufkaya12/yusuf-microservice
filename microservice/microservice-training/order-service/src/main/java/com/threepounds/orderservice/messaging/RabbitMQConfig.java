package com.threepounds.orderservice.messaging;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  @Bean
  public Queue createOrderQueue() {
    return new Queue("q.order");
  }
}
