package com.soft1851.api.controller.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Su
 * @className HelloControllerApi
 * @Description TODO
 * @Date 2020/11/13 22:52
 * @Version 1.0
 **/
public interface HelloControllerApi {

    @ApiOperation(value = "测试", tags = "测试")
    @GetMapping("/hello")
    Object hello();
}

