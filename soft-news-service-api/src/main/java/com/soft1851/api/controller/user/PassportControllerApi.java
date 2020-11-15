package com.soft1851.api.controller.user;

import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Su
 * @className PassportControllerApi
 * @Description TODO
 * @Date 2020/11/15 20:28
 * @Version 1.0
 **/
@Api(value = "用户注册登录", tags = {"用户注册登录的controller"})
@RequestMapping("passport")
public interface PassportControllerApi {

    /**
     * 发送短信
     * @param mobile 手机
     * @param request 请求
     * @return 统一响应
     */
    @ApiOperation(value = "获得短信验证码", notes = "过得短信验证码", httpMethod = "GET")
    @GetMapping("/smsCode")
    GraceResult getCode(@RequestParam String mobile, HttpServletRequest request);
}
