package org.example.mapper;


import org.example.model.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> getAllUsers();


}
