package com.accenture.be.access;

import com.accenture.be.entity.Flower;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Component
public class FlowerAccessImpl implements FlowerAccessService {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Flower> getFlowers() {
        List<Flower> flowerList = null;
        try{
            TypedQuery<Flower> query = entityManager.createQuery("SELECT f FROM Flower f", Flower.class);
            flowerList = query.getResultList();
            return flowerList;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public Flower getById(Long id) {
        try {
            Flower flower = entityManager.find(Flower.class, id);
            return flower;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Flower update(Flower flower) {
        return entityManager.merge(flower);
    }
}
