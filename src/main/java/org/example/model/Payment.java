package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {
    @Id(name = "payment_id")
    @Column(name = "payment_id")
    private int paymentId;
    @Column(name = "account_id")
    private int accountId;
    private BigDecimal amount;
    @Column(name = "currency_id")
    private int currencyId;
    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    public Payment() {
    }

    public Payment(int paymentId, int accountId, BigDecimal amount, int currencyId, LocalDateTime paymentDate) {
        this.paymentId = paymentId;
        this.accountId = accountId;
        this.amount = amount;
        this.currencyId = currencyId;
        this.paymentDate = paymentDate;
    }

    public Payment(int accountId, BigDecimal amount, int currencyId, LocalDateTime paymentDate) {
        this.accountId = accountId;
        this.amount = amount;
        this.currencyId = currencyId;
        this.paymentDate = paymentDate;
    }
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                ", currencyId=" + currencyId +
                ", paymentDate=" + paymentDate +
                '}';
    }
}
