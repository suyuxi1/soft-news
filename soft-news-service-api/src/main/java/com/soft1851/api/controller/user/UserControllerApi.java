package com.soft1851.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Su
 * @className UserControllerApi
 * @Description TODO
 * @Date 2020/11/14 16:42
 * @Version 1.0
 **/
public interface UserControllerApi {

    /**
     * 获取所有用户
     *
     * @return Object
     */
    @GetMapping("/users")
    Object getUsers();
}
