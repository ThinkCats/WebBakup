package com.thinkcat.service;

import com.thinkcat.common.Pager;
import com.thinkcat.domain.AdminUser;
import com.thinkcat.presistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by  Think Cat on 2015/10/15.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Pager<AdminUser> findUserPager(){
        List<AdminUser> userList = userMapper.findUserPager(0,10);
        Pager<AdminUser> userPager = new Pager<AdminUser>(userList.size(),1,10);
        //TODO
        return null;
    }

    @Transactional
    public int insertUser(AdminUser user){
        return userMapper.insertUser(user);
    }
}
