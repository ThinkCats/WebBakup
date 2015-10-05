package com.thinkcat.presistence;

import com.thinkcat.domain.AdminUser;

/**
 * Created by Think Cat on 15/10/4.
 */
public interface UserMapper {
    AdminUser findUserByName(String userName);
}
