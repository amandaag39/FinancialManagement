package org.example.model;

import org.example.utilities.LocalDateTimeAdapter;
import org.example.annotations.Column;
import org.example.annotations.Id;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @XmlElement(name = "account_id")
    @Id(name = "account_id")
    @Column(name = "account_id")
    private int accountId;
    @XmlElement(name = "user_id")
    @Column(name = "user_id")
    private int userId;
    @XmlElement(name = "account_type")
    @Column(name = "account_type")
    private String accountType;
    @XmlElement
    private BigDecimal balance;

    @XmlElement(name = "date_created")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

//    private User user; // Added Foreign key object

    public Account() {
        this.dateCreated = LocalDateTime.now();
    }

    // Constructor w/o accountId
    public Account(int userId, String accountType, BigDecimal balance, LocalDateTime dateCreated) {
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
        this.dateCreated = LocalDateTime.now();
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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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