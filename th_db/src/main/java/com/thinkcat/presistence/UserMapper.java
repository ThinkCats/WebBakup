package com.thinkcat.presistence;

import com.thinkcat.domain.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Think Cat on 15/10/4.
 */
public interface UserMapper {

    AdminUser findUserByName(String userName);

    List<AdminUser> findUserPager(AdminUser user);

    long findUserCount(AdminUser user);

    int insertUser(AdminUser user);
}
