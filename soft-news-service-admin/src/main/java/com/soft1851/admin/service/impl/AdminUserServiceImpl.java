package com.soft1851.admin.service.impl;

import com.soft1851.admin.mapper.AdminUserMapper;
import com.soft1851.admin.service.AdminUserService;
import com.soft1851.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author su
 * @className AdminUserServiceImpl
 * @Description AdminUserServiceImpl 实现类
 * @Date 2020/11/20
 * @Version 1.0
 **/
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    public AdminUserMapper adminUserMapper;

    @Override
    public AdminUser queryAdminByUsername(String username) {
        Example adminUserExample = new Example(AdminUser.class);
        Example.Criteria adminCriteria = adminUserExample.createCriteria();
        adminCriteria.andEqualTo("username", username);
        return adminUserMapper.selectOneByExample(adminUserExample);
    }
}
