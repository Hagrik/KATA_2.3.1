package ru.hagrik.webmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hagrik.webmvc.dao.RoleDao;
import ru.hagrik.webmvc.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    @Override
    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }

    @Override
    public Role getRoleByRoleName(String role) {
        return roleDao.getRoleByRoleName(role);
    }
}
