package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Stock;

import java.util.List;

public class StockService {
    private GenericDAOImpl<Stock> stockDAO;

    public StockService(GenericDAOImpl<Stock> stockDAO) {
        this.stockDAO = stockDAO;
    }

    public void createStock(Stock stock) {
        stockDAO.create(stock);
    }

    public Stock getStockById(int id) {
        return stockDAO.getById(id);
    }

    public List<Stock> getAllStocks() {
        return stockDAO.getAll();
    }

    public void updateStock(Stock stock) {
        stockDAO.update(stock);
    }

    public void deleteStock(Stock stock) {
        stockDAO.delete(stock);
    }
}
