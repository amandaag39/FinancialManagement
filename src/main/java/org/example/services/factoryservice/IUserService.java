package org.example.services.factoryservice;

import org.example.model.User;

import java.util.List;

public interface IUserService {
    void createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(User user);
//    void deleteUser(User user);

}
