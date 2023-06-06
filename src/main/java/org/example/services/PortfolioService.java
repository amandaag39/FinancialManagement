package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Portfolio;

import java.util.List;

public class PortfolioService {
    private GenericDAOImpl<Portfolio> portfolioDAO;

    public PortfolioService(GenericDAOImpl<Portfolio> portfolioDAO) {
        this.portfolioDAO = portfolioDAO;
    }

    public void createPortfolio(Portfolio portfolio) {
        portfolioDAO.create(portfolio);
    }

    public Portfolio getPortfolioById(int id) {
        return portfolioDAO.getById(id);
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioDAO.getAll();
    }

    public void updatePortfolio(Portfolio portfolio) {
        portfolioDAO.update(portfolio);
    }

    public void deletePortfolio(Portfolio portfolio) {
        portfolioDAO.delete(portfolio);
    }
}
