package com.example.consumer;

import com.example.consumer.api.Constants;
import com.example.consumer.api.PaymentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Zoltan Altfatter
 */
@Component
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = Constants.INCOMING_QUEUE_NAME)
    public void process(@Payload PaymentOrder paymentOrder) throws InsufficientFundsException {
        logger.info("Processing payload \'{}\'", paymentOrder);

        if (new Random().nextBoolean()) {
            throw new InsufficientFundsException("insufficient funds on account " + paymentOrder.getFrom());
        }
    }

}