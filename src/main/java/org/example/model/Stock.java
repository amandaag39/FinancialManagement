package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import java.math.BigDecimal;

public class Stock {
    @Id(name = "stock_symbol")
    @Column(name = "stock_symbol")
    private String stockSymbol;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "stock_description")
    private String stockDescription;
    private String exchange;
    private String sector;
    @Column(name = "market_cap")
    private BigDecimal marketCap;
    @Column(name = "dividend_yield")
    private BigDecimal dividendYield;
    @Column(name = "p_e_ratio")
    private BigDecimal peRatio;
    @Column(name = "earnings_per_share")
    private BigDecimal earningsPerShare;
    private BigDecimal beta;
    @Column(name = "high_price")
    private BigDecimal highPrice;
    @Column(name = "low_price")
    private BigDecimal lowPrice;
    @Column(name = "last_trade_price")
    private BigDecimal lastTradePrice;
    private int volume;

    public Stock() {
    }

    public Stock(String stockSymbol, String companyName, String stockDescription, String exchange, String sector,
                 BigDecimal marketCap, BigDecimal dividendYield, BigDecimal peRatio, BigDecimal earningsPerShare,
                 BigDecimal beta, BigDecimal highPrice, BigDecimal lowPrice, BigDecimal lastTradePrice, int volume) {
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.stockDescription = stockDescription;
        this.exchange = exchange;
        this.sector = sector;
        this.marketCap = marketCap;
        this.dividendYield = dividendYield;
        this.peRatio = peRatio;
        this.earningsPerShare = earningsPerShare;
        this.beta = beta;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.lastTradePrice = lastTradePrice;
        this.volume = volume;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStockDescription() {
        return stockDescription;
    }

    public void setStockDescription(String stockDescription) {
        this.stockDescription = stockDescription;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }

    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(BigDecimal peRatio) {
        this.peRatio = peRatio;
    }

    public BigDecimal getEarningsPerShare() {
        return earningsPerShare;
    }

    public void setEarningsPerShare(BigDecimal earningsPerShare) {
        this.earningsPerShare = earningsPerShare;
    }

    public BigDecimal getBeta() {
        return beta;
    }

    public void setBeta(BigDecimal beta) {
        this.beta = beta;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getLastTradePrice() {
        return lastTradePrice;
    }

    public void setLastTradePrice(BigDecimal lastTradePrice) {
        this.lastTradePrice = lastTradePrice;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", companyName='" + companyName + '\'' +
                ", stockDescription='" + stockDescription + '\'' +
                ", exchange='" + exchange + '\'' +
                ", sector='" + sector + '\'' +
                ", marketCap=" + marketCap +
                ", dividendYield=" + dividendYield +
                ", peRatio=" + peRatio +
                ", earningsPerShare=" + earningsPerShare +
                ", beta=" + beta +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", lastTradePrice=" + lastTradePrice +
                ", volume=" + volume +
                '}';
    }
}
