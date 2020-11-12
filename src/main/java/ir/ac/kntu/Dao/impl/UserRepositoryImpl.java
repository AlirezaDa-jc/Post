/*
 * @author Alireza.d.a
 */


package ir.ac.kntu.Dao.impl;

import ir.ac.kntu.Dao.UserRepository;
import ir.ac.kntu.base.repository.impl.BaseRepositoryImpl;
import ir.ac.kntu.domains.User;
import ir.ac.kntu.services.impl.UserServiceImpl;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUserName(String userName) {
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u where u.userName=:userName",
                User.class);

        query.setParameter("userName", userName);
        List<User> resultList = query.getResultList();
        em.getTransaction().commit();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }

    @Override
    public User userLogin(String userName, String password) {
        em.getTransaction().begin();
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u where u.userName=:name and u.password =:password",
                User.class);

        query.setParameter("name", userName);
        query.setParameter("password", password);
        if (query.getResultList().size() > 0) {
            User u = query.getSingleResult();
            em.getTransaction().commit();
            UserServiceImpl.setUser(u);
            return u;
        }
        em.getTransaction().rollback();
        return null;
    }
}
