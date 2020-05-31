package com.wypok.dao;

import com.wypok.models.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    List<User> getAll();
    User getUserByUsername(String username);

}
