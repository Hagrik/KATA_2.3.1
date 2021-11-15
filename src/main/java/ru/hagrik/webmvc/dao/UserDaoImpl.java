package ru.hagrik.webmvc.dao;

import org.springframework.stereotype.Repository;
import ru.hagrik.webmvc.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public List<User> userList() {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void getUser(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(int id) {

    }
}
