package ru.hagrik.webmvc;

import org.springframework.stereotype.Component;
import ru.hagrik.webmvc.dao.UserDao;
import ru.hagrik.webmvc.model.User;
import ru.hagrik.webmvc.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class UserGenerator {

    final UserService userService;

    public UserGenerator(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void userGenerator() {
        userService.createUser(new User("Hren", "Izosimov", 33));
        userService.createUser(new User("Alsu","Shaikheeva", 30));
        userService.createUser(new User("Boostik", "Jopov", 7));
    }
}
