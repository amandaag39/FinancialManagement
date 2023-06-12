package org.example.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stocks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stocks {
    @XmlElement(name = "stock")
    private List<Stock> stockList;

    //Getter and Setter for stockList
    public List<Stock> getStockList() {
        return stockList;
    }
    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }
}
