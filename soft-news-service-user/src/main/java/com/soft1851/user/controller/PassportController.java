package com.soft1851.user.controller;

import com.soft1851.api.BaseController;
import com.soft1851.api.controller.user.PassportControllerApi;
import com.soft1851.enums.UserStatus;
import com.soft1851.pojo.AppUser;
import com.soft1851.pojo.bo.RegistLoginBO;
import com.soft1851.result.GraceResult;
import com.soft1851.result.ResponseStatusEnum;
import com.soft1851.user.service.UserService;
import com.soft1851.utils.IpUtil;
import com.soft1851.utils.JsonUtil;
import com.soft1851.utils.SmsUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

/**
 * @author su
 * @className PassportController
 * @Description TODO
 * @Date 2020/11/15
 * @Version 1.0
 **/
@RestController
public class PassportController extends BaseController implements PassportControllerApi {


    @Resource
    private SmsUtil smsUtil;

    @Resource
    private UserService userService;

    @Override
    public GraceResult getCode(String mobile, HttpServletRequest request) {
        // 获取用户ip
        String userIp = IpUtil.getRequestIp(request);
        //根据用户的ip进行限制，限制用户在60秒内只能获得一次验证码
        redis.setnx60s(MOBILE_SMSCODE + ":" + userIp, userIp);
        // 生成随机验证码 发短信
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        System.out.println(random);
//        smsUtil.sendSms(mobile, random);
        redis.set(MOBILE_SMSCODE + ":" + mobile, random, 30 * 60);
        return GraceResult.ok();
    }

    @Override
    public GraceResult doSign(@Valid RegistLoginBO registLoginBO, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        // 0.判断BindingResult中是否保存了错误的验证信息，如果有，则需要返回
        if (result.hasErrors()) {
            Map<String, String> map = getErrors(result);
            return GraceResult.errorMap(map);
        }

        String mobile = registLoginBO.getMobile();
        String smsCode = registLoginBO.getSmsCode();

        //1.校验验证码是否匹配
        String redisSmsCode = redis.get(MOBILE_SMSCODE + ":" + mobile);
        if (StringUtils.isBlank(redisSmsCode) || !redisSmsCode.equalsIgnoreCase(smsCode)) {
            return GraceResult.errorCustom(ResponseStatusEnum.SMS_CODE_ERROR);
        }

        //2.查询数据库，判断该用户注册
        AppUser user = userService.queryMobileIsExist(mobile);
        if (user != null && user.getActiveStatus().equals(UserStatus.FROZEN.type)) {
            return GraceResult.errorCustom(ResponseStatusEnum.USER_FROZEN);
        } else if (user == null) {
            //如果用户没有注册过，则为null，需要信息入库
            user = userService.createUser(mobile);
        }

        //3.保存用户分布式会话相关操作
        int userActiveStatus = user.getActiveStatus();
        if (userActiveStatus != UserStatus.FROZEN.type) {
            //保存token到redis
            String uToken = UUID.randomUUID().toString();
            redis.set(REDIS_USER_TOKEN + ":" + user.getId(), uToken);
            redis.set(REDIS_USER_INFO + ":" + user.getId(), JsonUtil.objectToJson(user));

            //保存用户id和token到cookie中
            setCookie(request, response, "utoken", uToken, COOKIE_MONTH);
            setCookie(request, response, "uid", user.getId(), COOKIE_MONTH);
        }

        //4.用户登录或注册成功后，则需删除redis中的短信验证码
        redis.del(MOBILE_SMSCODE + ":" + mobile);

        //5.返回用户状态
        return GraceResult.ok(userActiveStatus);
    }

    @Override
    public GraceResult logout(HttpServletRequest request, HttpServletResponse response, String userId) {
        redis.del(REDIS_USER_TOKEN + ":" + userId);
        setCookie(request, response, "utoken", "", COOKIE_DELETE);
        setCookie(request, response, "uid", "", COOKIE_DELETE);
        return GraceResult.ok();
    }
}
