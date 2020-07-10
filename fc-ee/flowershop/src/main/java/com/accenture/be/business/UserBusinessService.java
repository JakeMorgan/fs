package com.accenture.be.business;

import com.accenture.be.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface UserBusinessService {
    User login(String UserName, String password);
    User register(String UserName, String Password, String Address, String Phone);
    User getInfo(String UserName);
    User updateBalance(String username, BigDecimal total);
}
