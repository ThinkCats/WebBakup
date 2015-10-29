package com.thinkweb.security;

import com.thinkcat.domain.AdminUser;
import com.thinkcat.presistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Think Cat on 15/10/4.
 */

@Component("userDetailService")
public class UserDetailService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AdminUser user = userMapper.findUserByName(userName);
        if (user == null){
            System.out.println("Error");
            throw new UsernameNotFoundException("User not found");
        }
        CustomerUser userDetail = new CustomerUser(userName,user.getPassword(),true,true,true,true,new ArrayList<GrantedAuthority>(0));
        userDetail.setUserId(user.getuId());
        return userDetail ;
    }
}
