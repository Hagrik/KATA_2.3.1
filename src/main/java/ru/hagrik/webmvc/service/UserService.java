package ru.hagrik.webmvc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.hagrik.webmvc.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getUserList();

    void createUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void removeUserById(Long id);

    @Override
    UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;
}
