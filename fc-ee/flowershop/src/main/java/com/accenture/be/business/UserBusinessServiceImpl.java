package com.accenture.be.business;
import com.accenture.be.access.UserAccessService;
import com.accenture.be.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserBusinessServiceImpl implements UserBusinessService {
    @Autowired
    private UserAccessService userAccessService;

    @Override
    public User login(String UserName, String Password){
        return userAccessService.getByUserNameAndPassword(UserName, Password) == null ? null : userAccessService.get(UserName);
    }

    @Override
    public User register(String UserName, String Password, String Address, String Phone){
        if ((userAccessService.get(UserName) == null)) {
            User user = new User(UserName, Password, Address, Phone);
            userAccessService.create(user);
            return user;
        }
            return null;
    }

    @Override
    public User getInfo(String UserName){
        User user = userAccessService.get(UserName);
        return user;
    }

    @Override
    public User updateBalance(String username, BigDecimal total) {
        User user = userAccessService.get(username);
        BigDecimal oBalance = user.getBalance();
        user.setBalance(user.getBalance().subtract(total));
        userAccessService.update(user);
        return user;
    }

    @Override
    public User updateData(String oldName, String username, String password, String address, String phone){
        User user = userAccessService.get(oldName);
        user.setUserName(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setPhone(phone);
        userAccessService.update(user);
        return user;
    }
}
