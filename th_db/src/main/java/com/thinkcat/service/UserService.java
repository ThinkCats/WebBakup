package com.thinkcat.service;

import com.thinkcat.dto.Pager;
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

    public Pager<AdminUser> findUserPager(int pageNum,int pageLength){
        AdminUser userParam = new AdminUser(pageNum,pageLength);
        List<AdminUser> userList = userMapper.findUserPager(userParam);
        long count = userMapper.findUserCount(null);
        Pager<AdminUser> userPager = new Pager<>((int)count,pageNum,pageLength);
        userPager.setList(userList);
        return userPager;
    }

    @Transactional
    public int insertUser(AdminUser user){
        if (user.getUserType() == null){
            user.setUserType(1);
        }
        return userMapper.insertUser(user);
    }

    public List<AdminUser> findAllUser(){
        return userMapper.findAllUser();
    }
}
