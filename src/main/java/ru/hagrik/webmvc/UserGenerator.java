package ru.hagrik.webmvc;

import org.springframework.stereotype.Component;
import ru.hagrik.webmvc.config.SpringSecurityConfig;
import ru.hagrik.webmvc.model.Role;
import ru.hagrik.webmvc.model.User;
import ru.hagrik.webmvc.service.RoleService;
import ru.hagrik.webmvc.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserGenerator {

    final UserService userService;
    final RoleService roleService;
    final SpringSecurityConfig springSecurityConfig;

    public UserGenerator(UserService userService, RoleService roleService, SpringSecurityConfig springSecurityConfig) {
        this.userService = userService;
        this.roleService = roleService;
        this.springSecurityConfig = springSecurityConfig;
    }

    @PostConstruct
    public void userGenerator() {
        Set<Role> roleAdmin = new HashSet<>();
        Set<Role> roleUser = new HashSet<>();
        Role admin = new Role("ROLE_ADMIN");
        roleAdmin.add(admin);
        Role user = new Role("ROLE_USER");
        roleUser.add(user);

        roleService.createRole(admin);
        roleService.createRole(user);

        userService.createUser(new User("Hren", "Izosimov", 33,
                springSecurityConfig.passwordEncoder()
                        .encode("hren"), roleAdmin , true));
        userService.createUser(new User("Alsu", "Shaikheeva", 30,
                springSecurityConfig.passwordEncoder()
                        .encode("alsu"), roleUser , true));
        userService.createUser(new User("Boostik", "Jopov", 7,
                springSecurityConfig.passwordEncoder()
                        .encode("jopov"), roleAdmin , true));
    }
}
