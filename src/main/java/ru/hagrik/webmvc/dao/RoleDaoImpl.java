package ru.hagrik.webmvc.dao;

import org.springframework.stereotype.Repository;
import ru.hagrik.webmvc.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public List<Role> getRoleList() {
        return entityManager.createQuery("FROM Role").getResultList();
    }

    @Override
    public Role getRoleByRoleName(String role) {
        return entityManager.createQuery(
                "FROM Role WHERE role=:role", Role.class)
                .setParameter("role", role).getSingleResult();
    }

}
