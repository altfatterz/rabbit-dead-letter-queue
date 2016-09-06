package com.example.consumer;

import com.example.consumer.api.Constants;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class AmqpConfig {

    @Bean
    Queue incomingQueue() {
        return QueueBuilder.durable(Constants.INCOMING_QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", Constants.DEAD_LETTER_QUEUE_NAME)
                .build();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
