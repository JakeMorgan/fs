package com.accenture.be.business;

import com.accenture.be.access.FlowerAccessService;
import com.accenture.be.entity.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowerBusinessServiceImpl implements FlowerBusinessService {
    @Autowired
    private FlowerAccessService flowerAccessService;

    public Flower getFlower(long id){
        return flowerAccessService.getById(id);
    }

    public List<Flower> flowersList(){
        List<Flower> flowerList = flowerAccessService.getFlowers();
        return flowerList;
    }

    public Flower updateFlowersCount(Long id, int quantity) throws Exception{
            Flower flower = flowerAccessService.getById(id);
            if(flower == null) throw new Exception("UpdateFlowersCount - flower null");
            flower.setQuantity(flower.getQuantity()- quantity);
            flowerAccessService.update(flower);
            return flower;
    }
}
