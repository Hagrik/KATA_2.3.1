package ru.hagrik.webmvc.dao;

import ru.hagrik.webmvc.model.User;

import java.util.List;

public interface UserDao {

    List<User> userList();
    void createUser (User user);
    void getUser (int id);
    void updateUser (User user);
    void removeUser (int id);

}
