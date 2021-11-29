package ru.hagrik.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hagrik.webmvc.model.Role;
import ru.hagrik.webmvc.model.User;
import ru.hagrik.webmvc.service.RoleService;
import ru.hagrik.webmvc.service.UserService;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    final UserService userService;
    final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userList(Model model) {
        List<User> users = userService.getUserList();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roleSet", roleService.getRoleList());
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String addUser(User user, @RequestParam(value = "roles") String role) {
        //Я 4 дня сидел, чтобы вымучать этот костыль,
        //буду рад обратной связи как это можно сделать иначе, спасибо))
        return getString(user, role);
    }

    @DeleteMapping("/removeUser/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/updateUserForm/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roleSet", roleService.getRoleList());
        return "updateUser";
    }

    @PatchMapping("/updateUser/{id}")
    public String updateUser(User user, @RequestParam(value = "roles") String role) {
        //Я 4 дня сидел, чтобы вымучать этот костыль,
        //буду рад обратной связи как это можно сделать иначе, спасибо))
        return getString(user, role);
    }

    @GetMapping("/userInfo/{id}")
    public String userInfoForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userInfo";
    }

    private String getString(User user, @RequestParam("roles") String role) {
        Set<Role> roleHashSet = new HashSet<>();
        String[] roles = role.split(",");
        for (String s : roles) {
            roleHashSet.add(roleService.getRoleByRoleName(s));
        }
        user.setRoles(roleHashSet);
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
