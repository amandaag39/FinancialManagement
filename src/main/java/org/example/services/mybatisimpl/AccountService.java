package org.example.services.mybatisimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.mapper.AccountMapper;
import org.example.model.Account;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService implements AccountMapper {
    private static final Logger LOGGER = LogManager.getLogger(AccountService.class);

    public Account getAccountById(int accountId) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            Account account = accountMapper.getAccountById(accountId);
            LOGGER.info("Account by ID: {}", account);
            return account;

        } catch (IOException e) {
            LOGGER.error("Error getting account by ID: " + accountId, e);
        }
        return null;
    }

    public List<Account> getAllAccounts() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            AccountMapper accountMapper = session.getMapper(AccountMapper.class);
            List<Account> accounts = accountMapper.getAllAccounts();
            LOGGER.info("All Accounts: {}", accounts);
            return accounts;

        } catch (IOException e) {
            LOGGER.error("Error getting all accounts", e);
        }
        return null;
    }

    public void insertAccount(Account account) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                AccountMapper accountMapper = session.getMapper(AccountMapper.class);
                accountMapper.insertAccount(account);
                session.commit();
                LOGGER.info("Account inserted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error inserting account", e);
        }
    }

    public void updateAccount(Account account) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                AccountMapper accountMapper = session.getMapper(AccountMapper.class);
                accountMapper.updateAccount(account);
                session.commit();
                LOGGER.info("Account updated successfully: " + account);
            }
        } catch (IOException e) {
            LOGGER.error("Error updating account: " + account, e);
        }
    }

    public void deleteAccountById(int accountId) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                AccountMapper accountMapper = session.getMapper(AccountMapper.class);
                accountMapper.deleteAccountById(accountId);
                session.commit();
                LOGGER.info("Account with ID " + accountId + " deleted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error deleting account with ID: " + accountId, e);
        }
    }
}
