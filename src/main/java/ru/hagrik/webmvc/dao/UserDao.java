package ru.hagrik.webmvc.dao;

import ru.hagrik.webmvc.model.User;

import java.util.List;

public interface UserDao {

    List<User> userList();

    void createUser(User user);

    User getUser(Long id);

    void updateUser(User user);

    void removeUser(Long id);

}
