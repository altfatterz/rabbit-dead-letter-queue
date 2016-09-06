package com.example.consumer;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

/**
 * @author Zoltan Altfatter
 */
public class InsufficientFundsException extends AmqpRejectAndDontRequeueException {

    public InsufficientFundsException(String message) {
        super(message);
    }

}
