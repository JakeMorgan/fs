package com.accenture.be.business;

import com.accenture.be.entity.Flower;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public interface FlowerBusinessService {
    Flower getFlower(String Name);
    List<Flower> flowersList();
    Flower updateFlowersCount(Long id, int count);
}
