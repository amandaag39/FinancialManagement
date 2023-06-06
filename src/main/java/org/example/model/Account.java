package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    @Id(name = "account_id")
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "account_type")
    private String accountType;
    private BigDecimal balance;
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    public Account() {
    }

    public Account(int accountId, int userId, String accountType, BigDecimal balance, LocalDateTime dateCreated) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
        this.dateCreated = dateCreated;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", dateCreated=" + dateCreated +
                '}';
    }
}