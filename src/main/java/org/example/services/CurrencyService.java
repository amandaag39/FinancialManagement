package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Currency;

import java.util.List;

public class CurrencyService {
    private GenericDAOImpl<Currency> currencyDAO;

    public CurrencyService(GenericDAOImpl<Currency> currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public void createCurrency(Currency currency) {
        currencyDAO.create(currency);
    }

    public Currency getCurrencyById(int id) {
        return currencyDAO.getById(id);
    }

    public List<Currency> getAllCurrencies() {
        return currencyDAO.getAll();
    }

    public void updateCurrency(Currency currency) {
        currencyDAO.update(currency);
    }

    public void deleteCurrency(Currency currency) {
        currencyDAO.delete(currency);
    }
}
