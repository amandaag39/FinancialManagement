package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.time.LocalDate;

public class Portfolio {
    @Id(name = "portfolio_id")
    @Column(name = "portfolio_id")
    private int portfolioId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "portfolio_name")
    private String portfolioName;
    @Column(name = "date_created")
    private LocalDate dateCreated;

    public Portfolio() {
    }

    public Portfolio(int portfolioId, int userId, String portfolioName, LocalDate dateCreated) {
        this.portfolioId = portfolioId;
        this.userId = userId;
        this.portfolioName = portfolioName;
        this.dateCreated = dateCreated;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", userId=" + userId +
                ", portfolioName='" + portfolioName + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
