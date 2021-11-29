package ru.hagrik.webmvc.dao;

import ru.hagrik.webmvc.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    void createUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUserById(Long id);

    User getUserByName(String name);

}
