package com.accenture.be.business;

import com.accenture.be.entity.Flower;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Component
public interface FlowerBusinessService {
    Flower getFlower(long id);
    List<Flower> flowersList();
    @Transactional
    Flower updateFlowersCount(Long id, int count) throws Exception;
}
