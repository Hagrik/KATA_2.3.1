package ru.hagrik.webmvc.dao;

import org.springframework.stereotype.Repository;
import ru.hagrik.webmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery(
                "from User u left join fetch u.roles")
                .getResultList().stream().distinct().toList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.createQuery(
                "SELECT u FROM User u JOIN FETCH u.roles r WHERE u.id =:id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUserById(Long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery(
                "SELECT u FROM User u JOIN FETCH u.roles r WHERE u.name =:name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
