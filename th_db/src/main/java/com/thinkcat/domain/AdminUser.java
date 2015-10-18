package com.thinkcat.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thinkcat.domain.base.BasePage;
import lombok.Data;

/**
 * Created by Think Cat on 15/10/5.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminUser extends BasePage {
    private Long uId;
    private String userName;
    private String password;
    private Integer userType;
    private Long roleId;
    private String description;

    public AdminUser() {
    }

    public AdminUser(Integer pageNum,Integer pageLength){
        this.setOffset((pageNum - 1)*pageLength);
        this.setPageLength(pageLength);
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
