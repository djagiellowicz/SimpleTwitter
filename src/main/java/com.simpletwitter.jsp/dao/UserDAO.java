package com.simpletwitter.jsp.dao;

import com.simpletwitter.jsp.model.User;

import java.util.HashMap;

public interface UserDAO {
    HashMap<Long,User> getMapOfUsers();
    User getUserById(Long id);
    User getUserByLogin(String login);
    User getUserByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    void deleteUser(User user);
}
