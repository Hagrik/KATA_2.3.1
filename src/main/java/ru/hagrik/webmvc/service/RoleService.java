package ru.hagrik.webmvc.service;

import ru.hagrik.webmvc.model.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);

    List<Role> getRoleList();

    Role getRoleByRoleName(String role);

}
