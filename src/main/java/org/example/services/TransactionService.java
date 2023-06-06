package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Transaction;

import java.util.List;

public class TransactionService {
    private GenericDAOImpl<Transaction> transactionDAO;

    public TransactionService(GenericDAOImpl<Transaction> transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    public void createTransaction(Transaction transaction) {
        transactionDAO.create(transaction);
    }

    public Transaction getTransactionById(int id) {
        return transactionDAO.getById(id);
    }

    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAll();
    }

    public void updateTransaction(Transaction transaction) {
        transactionDAO.update(transaction);
    }

    public void deleteTransaction(Transaction transaction) {
        transactionDAO.delete(transaction);
    }
}
