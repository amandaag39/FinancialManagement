package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Holdings {
    @Id(name = "holding_id")
    @Column(name = "holding_id")
    private int holdingId;
    @Column(name = "portfolio_id")
    private int portfolioId;
    @Column(name = "stock_symbol")
    private String stockSymbol;
    private int quantity;
    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    public Holdings() {
    }

    public Holdings(int holdingId, int portfolioId, String stockSymbol, int quantity, BigDecimal purchasePrice, LocalDate purchaseDate) {
        this.holdingId = holdingId;
        this.portfolioId = portfolioId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
    }

    public int getHoldingId() {
        return holdingId;
    }

    public void setHoldingId(int holdingId) {
        this.holdingId = holdingId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Holdings{" +
                "holdingId=" + holdingId +
                ", portfolioId=" + portfolioId +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", quantity=" + quantity +
                ", purchasePrice=" + purchasePrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
