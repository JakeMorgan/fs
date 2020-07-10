package com.accenture.fe.DTO;

import com.accenture.be.entity.OrderItems;

import java.util.List;
import java.util.Date;
public class OrderDTO {
    private Long userId;
    private int numberOrder;
    private List<OrderItems> itemsList;
    private Date orderDate;
}
