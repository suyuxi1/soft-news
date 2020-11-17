package com.soft1851.api.controller.user;

import com.soft1851.pojo.bo.UpdateUserInfoBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author Su
 * @className UserControllerApi
 * @Description TODO
 * @Date 2020/11/14 16:42
 * @Version 1.0
 **/
@Api(value = "用户信息相关Controller", tags = {"用户信息相关Controller"})
@RequestMapping("user")
public interface UserControllerApi {

    /**
     * 获取所有用户
     *
     * @return Object
     */
    @ApiOperation(value = "获取所有用户信息", notes = "获取所有用户信息", httpMethod = "POST")
    @PostMapping("/all")
    GraceResult getUsers();

    /**
     * 获取用户基本信息
     *
     * @param userId 用户id
     * @return GraceResult
     */
    @ApiOperation(value = "获取用户基本信息", notes = "获取所有基本信息", httpMethod = "POST")
    @PostMapping("/userInfo")
    GraceResult getUserInfo(@RequestParam String userId);

    /**
     * 更新用户账户信息
     *
     * @param updateUserInfoBO 入参
     * @param result 校验结果
     * @return GraceResult
     */
    @ApiOperation(value = "完善用户信息", notes = "完善用户信息", httpMethod = "POST")
    @PostMapping("/updateUserInfo")
    GraceResult updateUserInfo(@RequestBody @Valid UpdateUserInfoBO updateUserInfoBO, BindingResult result);

}
