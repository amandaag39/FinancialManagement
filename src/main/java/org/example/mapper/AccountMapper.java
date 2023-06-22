package org.example.mapper;

import org.example.model.Account;

import java.util.List;

public interface AccountMapper {
    Account getAccountById(int accountId);

    List<Account> getAllAccounts();

    void insertAccount(Account account);

    void updateAccount(Account account);

    void deleteAccountById(int accountId);
}
