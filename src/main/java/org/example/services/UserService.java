package org.example.services;

import org.example.dao.GenericDAOImpl;
import org.example.model.User;

import java.util.List;

public class UserService  {
    private GenericDAOImpl<User> userDAO;

    public UserService(GenericDAOImpl<User> userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) {
        userDAO.create(user);
    }

    public User getUserById(int id) {
        return userDAO.getById(id);
    }

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }
}
