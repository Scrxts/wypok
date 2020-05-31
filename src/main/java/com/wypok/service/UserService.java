package com.wypok.service;

import com.wypok.dao.DAOFactory;
import com.wypok.dao.UserDAO;
import com.wypok.models.User;

public class UserService {

    public void addUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDao = factory.getUserDAO();
        userDao.create(user);
    }
}