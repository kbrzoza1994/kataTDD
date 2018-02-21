package org.kata.transfer;

import java.math.BigDecimal;

public class Transaction {
    private int idFrom;
    private int idTo;
    private BigDecimal amount;

    public Transaction(int idFrom, int idTo, BigDecimal amount) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.amount = amount;
    }

    public int getIdFrom() {
        return idFrom;
    }

    public int getIdTo() {
        return idTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
