package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Holdings;

import java.util.List;

public class HoldingsService {
    private GenericDAOImpl<Holdings> holdingsDAO;

    public HoldingsService(GenericDAOImpl<Holdings> holdingsDAO) {
        this.holdingsDAO = holdingsDAO;
    }

    public void createHoldings(Holdings holdings) {
        holdingsDAO.create(holdings);
    }

    public Holdings getHoldingsById(int id) {
        return holdingsDAO.getById(id);
    }

    public List<Holdings> getAllHoldings() {
        return holdingsDAO.getAll();
    }

    public void updateHoldings(Holdings holdings) {
        holdingsDAO.update(holdings);
    }

    public void deleteHoldings(Holdings holdings) {
        holdingsDAO.delete(holdings);
    }
}
