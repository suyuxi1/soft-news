package com.soft1851.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author su
 * @className HelloController
 * @Description TODO
 * @Date 2020/11/13
 * @Version 1.0
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello(){
        return "hello";
    }
}
