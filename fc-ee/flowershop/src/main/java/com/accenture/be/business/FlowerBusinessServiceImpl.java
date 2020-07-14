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

    public Flower getFlower(String Name){
        return null;
    }

    public List<Flower> flowersList(){
        List<Flower> flowerList = flowerAccessService.getFlowers();
        return flowerList;
    }

    public Flower updateFlowersCount(Long id, int quantity){
        Flower flower = flowerAccessService.getById(id);
        flower.setQuantity(flower.getQuantity()- quantity);
        flowerAccessService.update(flower);
        return flower;
    }
}
