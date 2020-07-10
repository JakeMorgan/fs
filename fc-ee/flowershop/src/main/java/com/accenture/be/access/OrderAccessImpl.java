package com.accenture.be.access;

import com.accenture.be.entity.Order;
import com.accenture.be.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class OrderAccessImpl implements OrderAccessService {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Order> getOrders() {
        List<Order> orderList = null;
        try{
            TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o", Order.class);
            orderList = query.getResultList();
            return orderList;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public Order create(Order order) {
        try{
            entityManager.persist(order);
            return order;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public Order update(Order order) {
        try{
            entityManager.merge(order);
            return  order;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public Order getById(Long id) {
        try{
            TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.id=:id", Order.class);
            query.setParameter("id", id);
            Order order = query.getSingleResult();
            return order;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public List<Order> getOrderByUser(User user) {
        try {
            List<Order> orderList = null;
            TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order WHERE o.user=:user", Order.class);
            query.setParameter("user", user);
            orderList = query.getResultList();
            return orderList;
        }catch(NoResultException ex){
            return null;
        }
    }
}
