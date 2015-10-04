package com.thinkcat.presistence;

import com.thinkcat.domain.User;

/**
 * Created by Think Cat on 15/10/4.
 */
public interface UserMapper {
    User findUserByName(String userName);
}
