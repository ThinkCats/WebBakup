package com.thinkcat.presistence;

import com.thinkcat.domain.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Think Cat on 15/10/4.
 */
public interface UserMapper {

    List<AdminUser> findAllUser();

    AdminUser findUserByName(String userName);

    List<AdminUser> findUserPager(AdminUser user);

    long findUserCount(AdminUser user);

    int insertUser(AdminUser user);

    List<AdminUser> findUserByParentId(@Param("parentId")Long parentId);

    void addUserXref(@Param("parentId") Long parentId,@Param("uId") Long userId);
}
