package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    @Id(name = "transaction_id")
    @Column(name = "transaction_id")
    private int transactionId;
    @Column(name = "account_id")
    private int accountId;
    private BigDecimal amount;
    @Column(name = "transaction_date")
    private Date transactionDate;
    @Column(name = "currency_id")
    private int currencyId;
    @Column(name = "transaction_type_id")
    private int transactionTypeId;

    public Transaction() {
    }

    public Transaction(int transactionId, int accountId, BigDecimal amount, Date transactionDate, int currencyId,
                       int transactionTypeId) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.currencyId = currencyId;
        this.transactionTypeId = transactionTypeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", currencyId=" + currencyId +
                ", transactionTypeId=" + transactionTypeId +
                '}';
    }
}
