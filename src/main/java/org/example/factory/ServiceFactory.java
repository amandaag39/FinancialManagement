package org.example.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.GenericDAOImpl;
import org.example.model.User;
import org.example.services.UserService;
import org.example.services.factoryservice.IUserService;
import org.example.services.mybatisimpl.UserServiceMyBatis;
import org.example.utilities.ConnectionPool;

public class ServiceFactory {
    private static final Logger logger = LogManager.getLogger(ServiceFactory.class);
    public enum ImplementationType {
        DAO,
        MYBATIS
    }

    public static ConnectionPool connectionPool = new ConnectionPool();

    public static IUserService createUserService(ImplementationType type) {
        logger.info("Creating UserService with implementation type: {}", type);
        if (type == ImplementationType.DAO) {
            GenericDAOImpl<User> userDAO = new GenericDAOImpl<>(connectionPool, User.class);
            logger.debug("Creating UserService with DAO implementation");
            return new UserService(userDAO);
        } else if (type == ImplementationType.MYBATIS) {
            UserServiceMyBatis userServiceMyBatis = new UserServiceMyBatis();
            logger.debug("Creating UserService with MyBatis implementation");
            return userServiceMyBatis;
        }

        throw new IllegalArgumentException("Invalid implementation type: " + type);
    }
    public static void closeConnectionPool() {
        logger.info("Closing ConnectionPool");
        connectionPool.close();
    }
}
