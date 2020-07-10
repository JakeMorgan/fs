package com.accenture.be.access;

import com.accenture.be.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
@Component
@Service
public class UserAccessImpl implements UserAccessService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User get(String UserName) {
        try {
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class);
            query.setParameter("username", UserName);
            return query.getSingleResult();
        }catch(NoResultException ex){
                return null;
            }
    }

    @Override
    public User getByUserNameAndPassword(String UserName, String Password) {
        try {
            TypedQuery<User> query = entityManager.createQuery("Select u From User u Where u.username=:username and " +
                    "u.password=:password", User.class);
            query.setParameter("username", UserName);
            query.setParameter("password", Password);
            return query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public User create(User user) {
        try{
            entityManager.persist(user);
            return user;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public User update(User user) {
        try{
            return entityManager.merge(user);
        }catch(NoResultException ex){
            return null;
        }
    }
}
