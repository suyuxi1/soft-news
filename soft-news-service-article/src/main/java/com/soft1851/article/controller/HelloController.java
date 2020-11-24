package com.soft1851.article.controller;

import com.soft1851.api.controller.user.HelloControllerApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author su
 * @className HelloController
 * @Description TODO
 * @Date 2020/11/24
 * @Version 1.0
 **/
@RestController
public class HelloController implements HelloControllerApi {


    @Override
    public Object hello() {
        System.out.println("测试！！");
        return "hello article";
    }
}
