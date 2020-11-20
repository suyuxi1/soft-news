package com.soft1851.api.controller.admin;

import com.soft1851.pojo.bo.AdminLoginBO;
import com.soft1851.result.GraceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Su
 * @className AdminMsgControllerApi
 * @Description 管理员Api接口
 * @Date 2020/11/20 16:28
 * @Version 1.0
 **/
@Api(value = "管理员维护",tags = {"管理员维护controller"})
@RequestMapping("adminMsg")
public interface AdminMsgControllerApi {

    /**
     * 管理员登录
     *
     * @param adminLoginBO 管理员登录BO类
     * @param request      请求
     * @param response     响应
     * @return GraceResult
     */
    @PostMapping("adminLogin")
    @ApiOperation(value = "管理员登录", notes = "管理员登录", httpMethod = "POST")
    GraceResult adminLogin(@RequestBody AdminLoginBO adminLoginBO, HttpServletRequest request, HttpServletResponse response);

    /**
     * 查询管理员是否存在
     *
     * @param username 用户名
     * @return  GraceResult
     */
    @PostMapping("adminIsExist")
    @ApiOperation(value = "查询管理员是否存在", notes = "查询管理人员是否存在", httpMethod = "POST")
    GraceResult adminIsExist(@RequestParam String username);
}
