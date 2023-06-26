package org.example;

import org.example.factory.ServiceFactory;
import org.example.model.User;
import org.example.services.factoryservice.IUserService;


public class ServiceFactoryRunner {
    public static void main(String[] args) {
        runUserServiceExample();
    }

    private static void runUserServiceExample() {
        IUserService userServiceDAO = ServiceFactory.createUserService(ServiceFactory.ImplementationType.DAO);
        IUserService userServiceMyBatis = ServiceFactory.createUserService(ServiceFactory.ImplementationType.MYBATIS);

        int userId = 1;

        User retrievedUserDAO = userServiceDAO.getUserById(userId);
        System.out.println("Retrieved user (DAO): " + retrievedUserDAO);

        User retrievedUserMyBatis = userServiceMyBatis.getUserById(userId);
        System.out.println("Retrieved user (MyBatis): " + retrievedUserMyBatis);
    }
}
