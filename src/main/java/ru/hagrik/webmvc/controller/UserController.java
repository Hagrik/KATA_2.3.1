package ru.hagrik.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hagrik.webmvc.model.User;
import ru.hagrik.webmvc.service.UserService;

import java.util.List;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String userList(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/addUser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "/addUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/removeUser/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @PatchMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUser(id);
        user.setName(User.class.getName());
        return "user";
    }

}
