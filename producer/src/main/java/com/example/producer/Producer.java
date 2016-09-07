package com.example.producer;

import com.example.producer.api.Constants;
import com.example.producer.api.PaymentOrder;
import org.iban4j.Iban;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @author Zoltan Altfatter
 */
@Component
public class Producer {

    static final Logger logger = LoggerFactory.getLogger(Producer.class);
    static final Random random = new Random();

    private AmqpTemplate amqpTemplate;

    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Scheduled(fixedDelay = 5000L)
    public void send() {

        PaymentOrder paymentOrder = new PaymentOrder(
                Iban.random().toFormattedString(),
                Iban.random().toFormattedString(),
                new BigDecimal(1D + random.nextDouble() * 100D).setScale(2, BigDecimal.ROUND_FLOOR));

        logger.info("Sending payload \'{}\'", paymentOrder);

        amqpTemplate.convertAndSend(Constants.EXCHANGE_NAME, Constants.ROUTING_KEY_NAME, paymentOrder);
    }
}
