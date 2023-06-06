package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

public class Currency {
    @Id(name = "currency_id")
    @Column(name = "currency_id")
    private int currencyId;
    @Column(name = "currency_code")
    private String currencyCode;
    @Column(name = "currency_name")
    private String currencyName;
    private String symbol;

    public Currency() {
    }

    public Currency(int currencyId, String currencyCode, String currencyName, String symbol) {
        this.currencyId = currencyId;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.symbol = symbol;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyId=" + currencyId +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
