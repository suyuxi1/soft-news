package com.soft1851.api.config;

import com.soft1851.api.interceptors.AdminTokenInterceptor;
import com.soft1851.api.interceptors.PassportInterceptor;
import com.soft1851.api.interceptors.UserActiveInterceptor;
import com.soft1851.api.interceptors.UserTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author su
 * @className InterceptorConfig
 * @Description TODO
 * @Date 2020/11/15
 * @Version 1.0
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public PassportInterceptor passportInterceptor() {
        return new PassportInterceptor();
    }

    @Bean
    public UserTokenInterceptor userTokenInterceptor(){
        return new UserTokenInterceptor();
    }

    @Bean
    public UserActiveInterceptor userActiveInterceptor(){
        return new UserActiveInterceptor();
    }

    @Bean
    public AdminTokenInterceptor adminTokenInterceptor(){
        return new AdminTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器，添加拦截路由
        registry.addInterceptor(passportInterceptor())
                .addPathPatterns("/passport/smsCode");

        //用户登录状态拦截器
        registry.addInterceptor(userTokenInterceptor())
                .addPathPatterns("/user/userBasicInfo")
                .addPathPatterns("/user/updateUserInfo");
//                .addPathPatterns("/fs/uploadFace");

        //用户状态激活拦截器
        registry.addInterceptor(userActiveInterceptor())
                .addPathPatterns("/user/userInfo");

        //管理员登录拦截
        registry.addInterceptor(adminTokenInterceptor())
                .addPathPatterns("/adminMsg/adminIsExist");
    }
}
