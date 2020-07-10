package com.accenture.be.access;

import com.accenture.be.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserAccessService {
    User get(String UserName);
    @Transactional
    User getByUserNameAndPassword(String UserName, String Password);
    @Transactional
    User create(User user);
    @Transactional
    User update(User user);
}
