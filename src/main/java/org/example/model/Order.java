package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    @Id(name = "order_id")
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "stock_symbol")
    private String stockSymbol;
    @Column(name = "order_type")
    private String orderType;
    private int quantity;
    private BigDecimal price;
    @Column(name = "order_date")
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(int orderId, int accountId, String stockSymbol, String orderType, int quantity, BigDecimal price, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.accountId = accountId;
        this.stockSymbol = stockSymbol;
        this.orderType = orderType;
        this.quantity = quantity;
        this.price = price;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", accountId=" + accountId +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", orderType='" + orderType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate=" + orderDate +
                '}';
    }
}
