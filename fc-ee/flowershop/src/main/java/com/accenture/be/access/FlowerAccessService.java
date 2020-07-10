package com.accenture.be.access;

import com.accenture.be.entity.Flower;

import java.util.List;

public interface FlowerAccessService {
    List<Flower> getFlowers();
    Flower getById(Long id);
    Flower update(Flower flower);
}
