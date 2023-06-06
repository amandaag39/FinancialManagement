package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.Account;

import java.util.List;

public class AccountService {
    private GenericDAOImpl<Account> accountDAO;

    public AccountService(GenericDAOImpl<Account> accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void createAccount(Account account) {
        accountDAO.create(account);
    }

    public Account getAccountById(int id) {
        return accountDAO.getById(id);
    }

    public List<Account> getAllAccounts() {
        return accountDAO.getAll();
    }

    public void updateAccount(Account account) {
        accountDAO.update(account);
    }

    public void deleteAccount(Account account) {
        accountDAO.delete(account);
    }
}
