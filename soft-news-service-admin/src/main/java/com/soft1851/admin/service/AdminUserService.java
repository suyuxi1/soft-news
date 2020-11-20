package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;

/**
 * @author Su
 * @className AdminUserService
 * @Description AdminUserService接口
 * @Date 2020/11/20 16:20
 * @Version 1.0
 **/
public interface AdminUserService {

    /**
     * 获取管理员用户信息
     *
     * @param username 用户名
     * @return AdminUser
     */
    AdminUser queryAdminByUsername(String username);
}
