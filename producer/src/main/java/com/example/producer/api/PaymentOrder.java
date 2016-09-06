package com.example.producer.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Zoltan Altfatter
 */
public class PaymentOrder {

    String from;
    String to;
    BigDecimal amount;

    @JsonCreator
    public PaymentOrder(@JsonProperty("from") String from,
                        @JsonProperty("to") String to,
                        @JsonProperty("amount") BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "PaymentOrder{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}