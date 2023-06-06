package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.TransactionType;

import java.util.List;

public class TransactionTypeService {
    private GenericDAOImpl<TransactionType> transactionTypeDAO;

    public TransactionTypeService(GenericDAOImpl<TransactionType> transactionTypeDAO) {
        this.transactionTypeDAO = transactionTypeDAO;
    }

    public void createTransactionType(TransactionType transactionType) {
        transactionTypeDAO.create(transactionType);
    }

    public TransactionType getTransactionTypeById(int id) {
        return transactionTypeDAO.getById(id);
    }

    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeDAO.getAll();
    }

    public void updateTransactionType(TransactionType transactionType) {
        transactionTypeDAO.update(transactionType);
    }

    public void deleteTransactionType(TransactionType transactionType) {
        transactionTypeDAO.delete(transactionType);
    }
}
