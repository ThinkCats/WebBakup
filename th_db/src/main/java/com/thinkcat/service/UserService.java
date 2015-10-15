package com.thinkcat.service;

import com.thinkcat.domain.AdminUser;
import com.thinkcat.presistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by  Think Cat on 2015/10/15.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int insertUser(AdminUser user){
        return userMapper.insertUser(user);
    }
}
