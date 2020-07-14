package com.accenture.fe.DTO;

import com.accenture.be.entity.OrderItems;

import java.util.List;
import java.util.Date;
public class Order {
    private Long userId;
    private int numberOrder;
    private List<OrderItems> itemsList;
    private Date orderDate;

    public Order(){

    }

    public Order(Long userId, int numberOrder, List<OrderItems> itemsList, Date orderDate) {
        this.userId = userId;
        this.numberOrder = numberOrder;
        this.itemsList = itemsList;
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public List<OrderItems> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<OrderItems> itemsList) {
        this.itemsList = itemsList;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}


