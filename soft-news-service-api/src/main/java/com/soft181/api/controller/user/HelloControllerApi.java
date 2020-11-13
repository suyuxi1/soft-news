package com.soft181.api.controller.user;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Su
 * @className HelloControllerApi
 * @Description TODO
 * @Date 2020/11/13 22:52
 * @Version 1.0
 **/
public interface HelloControllerApi {

    @GetMapping("/hello")
    Object hello();
}

