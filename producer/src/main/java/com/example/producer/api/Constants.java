package com.example.producer.api;

/**
 * @author Zoltan Altfatter
 */
public class Constants {

    public static final String EXCHANGE_NAME = "payment-orders.exchange";
    public static final String ROUTING_KEY_NAME = "payment-orders";

    public static final String INCOMING_QUEUE_NAME = "payment-orders.incoming.queue";
    public static final String DEAD_LETTER_QUEUE_NAME = "payment-orders.dead-letter.queue";

}