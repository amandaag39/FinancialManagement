package org.example.mapper;


import org.example.model.User;

import java.util.List;

public interface UserMapper {
    User selectUserById(int id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    List<User> getAllUsers();


}
