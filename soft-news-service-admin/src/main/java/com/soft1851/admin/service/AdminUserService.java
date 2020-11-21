package com.soft1851.admin.service;

import com.soft1851.pojo.AdminUser;
import com.soft1851.pojo.bo.NewAdminBO;
import com.soft1851.utils.PageGridResult;

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


    /**
     * 新增管理员
     *
     * @param newAdminBO 入参
     */
    void createAdminUser(NewAdminBO newAdminBO);


    /**
     * 分页查询管理员
     *
     * @param page 当前页
     * @param pageSize 条数
     * @return PageGridResult
     */
    PageGridResult queryAdminList(Integer page, Integer pageSize);

    /**
     * 修改指定管理员的faceId
     *
     * @param username 用户名
     * @param faceId   faceId
     */
    AdminUser updateAdmin(String username, String faceId);
}


