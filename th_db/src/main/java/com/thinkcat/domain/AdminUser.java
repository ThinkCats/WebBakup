package com.thinkcat.domain;

import lombok.Data;

/**
 * Created by Think Cat on 15/10/5.
 */
@Data
public class AdminUser {
    private Long uId;
    private String userName;
    private String password;
    private Integer userType;
    private Long roleId;
    private String description;

}
