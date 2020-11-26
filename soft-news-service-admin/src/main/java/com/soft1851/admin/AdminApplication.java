package com.soft1851.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author su
 * @className Application
 * @Description admin模块启动类
 * @Date 2020/11/20
 * @Version 1.0
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.admin.mapper")
@ComponentScan({"com.soft1851" ,"org.n3r.idworker"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
