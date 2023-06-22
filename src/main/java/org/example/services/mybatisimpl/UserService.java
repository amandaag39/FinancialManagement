package org.example.services.mybatisimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.mapper.UserMapper;
import org.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserService implements UserMapper {

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    public User selectUserById(int id) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.selectUserById(id);
            LOGGER.info("User by ID: {}", user);
            return user;

        } catch (IOException e) {
            LOGGER.error("Error selecting user by ID: " + id, e);
        }
        return null;
    }

    public List<User> getAllUsers() {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> users = userMapper.getAllUsers();
            LOGGER.info("All Users: {}", users);
            return users;

        } catch (IOException e) {
            LOGGER.error("Error getting all users", e);
        }
        return null;
    }

    public void insertUser(User user) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper userMapper = session.getMapper(UserMapper.class);
                userMapper.insertUser(user);
                session.commit();
                LOGGER.info("User inserted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error inserting user", e);
        }
    }

    public void updateUser(User user) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.updateUser(user);
            session.commit();
            LOGGER.info("User updated successfully: " + user);

        } catch (IOException e) {
            LOGGER.error("Error updating user", e);
        }
    }

    public void deleteUserById(int id) {
        try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                UserMapper userMapper = session.getMapper(UserMapper.class);
                userMapper.deleteUserById(id);
                session.commit();
                LOGGER.info("User with ID " + id + " deleted successfully!");
            }
        } catch (IOException e) {
            LOGGER.error("Error deleting user with ID: " + id, e);
        }
    }
}
