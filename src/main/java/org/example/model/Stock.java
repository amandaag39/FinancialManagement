package org.example.model;

import org.example.annotations.Column;
import org.example.annotations.Id;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "stock")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stock {
    @XmlElement(name = "stock_symbol")
    @Id(name = "stock_symbol")
    @Column(name = "stock_symbol")
    private String stockSymbol;
    @XmlElement(name = "company_name")
    @Column(name = "company_name")
    private String companyName;
    @XmlElement(name = "stock_description")
    @Column(name = "stock_description")
    private String stockDescription;
    @XmlElement
    private String exchange;
    @XmlElement
    private String sector;
    @XmlElement(name = "market_cap")
    @Column(name = "market_cap")
    private BigDecimal marketCap;
    @XmlElement(name = "dividend_yield")
    @Column(name = "dividend_yield")
    private BigDecimal dividendYield;
    @XmlElement(name = "p_e_ratio")
    @Column(name = "p_e_ratio")
    private BigDecimal peRatio;
    @XmlElement(name = "earnings_per_share")
    @Column(name = "earnings_per_share")
    private BigDecimal earningsPerShare;
    @XmlElement
    private BigDecimal beta;
    @XmlElement(name = "high_price")
    @Column(name = "high_price")
    private BigDecimal highPrice;
    @XmlElement(name = "low_price")
    @Column(name = "low_price")
    private BigDecimal lowPrice;
    @XmlElement(name = "last_trade_price")
    @Column(name = "last_trade_price")
    private BigDecimal lastTradePrice;
    @XmlElement
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
