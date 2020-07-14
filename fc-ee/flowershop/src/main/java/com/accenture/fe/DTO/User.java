package com.accenture.fe.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private BigDecimal balance;

    public User(){

    }

    public User(Long id, String userName, String password, String address, String phone, BigDecimal balance) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
