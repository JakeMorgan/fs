package com.accenture.be.entity;
import java.math.BigDecimal;
import java.util.Date;
import com.accenture.be.entity.User;
import com.accenture.fe.Enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderCreateDate;
    private Date orderCompleteDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn
    private User user;
    private BigDecimal total;
    public OrderStatus status;

    public Order(User user, BigDecimal total){
        this.user = user;
        this.total = total;
        this.orderCreateDate = new Date();
        this.status = OrderStatus.Created;
        this.orderCompleteDate = null;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public void setCompleteDate(Date orderCompleteDate){
        this.orderCompleteDate = orderCompleteDate;
    }
}
