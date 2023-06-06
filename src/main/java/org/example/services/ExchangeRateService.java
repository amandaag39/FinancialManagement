package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.ExchangeRate;

import java.util.List;

public class ExchangeRateService {
    private GenericDAOImpl<ExchangeRate> exchangeRateDAO;

    public ExchangeRateService(GenericDAOImpl<ExchangeRate> exchangeRateDAO) {
        this.exchangeRateDAO = exchangeRateDAO;
    }

    public void createExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateDAO.create(exchangeRate);
    }

    public ExchangeRate getExchangeRateById(int id) {
        return exchangeRateDAO.getById(id);
    }

    public List<ExchangeRate> getAllExchangeRates() {
        return exchangeRateDAO.getAll();
    }

    public void updateExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateDAO.update(exchangeRate);
    }

    public void deleteExchangeRate(ExchangeRate exchangeRate) {
        exchangeRateDAO.delete(exchangeRate);
    }
}
