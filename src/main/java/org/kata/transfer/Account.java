package org.kata.transfer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private BigDecimal balance;
    private List<Transaction> listOfTransactions;

    Account(int id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        listOfTransactions = new ArrayList<>();
    }

    public boolean TransferMoney(BigDecimal amount, Account to) {
        if (amount.compareTo(this.balance) == 1) {
            System.out.println("Transfer money failed, you don't have such money!");
            return false;
        } else {
            this.balance = this.balance.subtract(amount);
            to.setBalance(amount);
            Transaction transaction = new Transaction(id, to.getId(), amount);
            this.listOfTransactions.add(transaction);
            to.getListOfTransactions().add(transaction);
            System.out.println("Transfer successful");
            return true;
        }
    }

    public void setBalance(BigDecimal balance) {
        this.balance = this.balance.add(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }
}
