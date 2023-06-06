package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

public class ExchangeRate {
    @Id(name = "exchange_rate_id")
    @Column(name = "exchange_rate_id")
    private int exchangeRateId;
    @Column(name = "base_currency_id")
    private int baseCurrencyId;
    @Column(name = "target_currency_id")
    private int targetCurrencyId;
    private double rate;

    public ExchangeRate() {
    }

    public ExchangeRate(int exchangeRateId, int baseCurrencyId, int targetCurrencyId, double rate) {
        this.exchangeRateId = exchangeRateId;
        this.baseCurrencyId = baseCurrencyId;
        this.targetCurrencyId = targetCurrencyId;
        this.rate = rate;
    }

    public int getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(int exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public int getBaseCurrencyId() {
        return baseCurrencyId;
    }

    public void setBaseCurrencyId(int baseCurrencyId) {
        this.baseCurrencyId = baseCurrencyId;
    }

    public int getTargetCurrencyId() {
        return targetCurrencyId;
    }

    public void setTargetCurrencyId(int targetCurrencyId) {
        this.targetCurrencyId = targetCurrencyId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "exchangeRateId=" + exchangeRateId +
                ", baseCurrencyId=" + baseCurrencyId +
                ", targetCurrencyId=" + targetCurrencyId +
                ", rate=" + rate +
                '}';
    }
}
