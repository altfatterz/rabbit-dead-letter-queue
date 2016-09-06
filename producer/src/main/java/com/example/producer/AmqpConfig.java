package com.example.producer;

import com.example.producer.api.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class AmqpConfig {

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    Queue incomingQueue() {
        return QueueBuilder.durable(Constants.INCOMING_QUEUE_NAME)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", Constants.DEAD_LETTER_QUEUE_NAME)
                .build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(incomingQueue()).to(exchange()).with(Constants.ROUTING_KEY_NAME);
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(Constants.DEAD_LETTER_QUEUE_NAME).build();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
