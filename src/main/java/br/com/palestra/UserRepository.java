package br.com.palestra;


import javax.enterprise.context.ApplicationScoped;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;


@ApplicationScoped
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createNamedQuery("User.findAll", User.class)
                .getResultList();
    }

    public User findUserById(Long id) {

        User user = entityManager.find(User.class, id);

        if (user == null) {
            throw new WebApplicationException("Usuario com id " + id + " não existe.", 404);
        }
        return user;
    }
    @Transactional
    public void updateUser(Long id, String nome, String email) {

        User user = findUserById(id);
        user.setNome(nome);
        user.setEmail(email);
    }
    @Transactional
    public void createUser(User user) {

        entityManager.persist(user);

    }
    @Transactional
    public void deleteUser(Long userId) {

        User c = findUserById(userId);
        entityManager.remove(c);
    }

}
