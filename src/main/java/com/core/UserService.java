package com.core;

import com.SGALogger;
import com.db.UserDAO;

import java.util.List;

/**
 * Created by Jigar on 7/10/2016.
 */
public class UserService extends SGALogger {
    public List<User> getUsers() {
        UserDAO userDAO = new UserDAO();
        return userDAO.listUser();
    }

    public User getUser(int userId) {
        return (new User(0, 0, "empty"));
    }

    public User createUser(User newUser) {
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(newUser);
        return (new User(0, 0, "empty"));
    }

    public void deleteUser(int deletedId) {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(deletedId);

    }

    public User updateUser(User updatedUser) {
        UserDAO userDAO = new UserDAO();
        userDAO.updateUser(updatedUser);
        return (new User(0, 0, "empty"));
    }
}