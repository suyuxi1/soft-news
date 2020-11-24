package com.soft1851.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author su
 * @className ArticleApplication
 * @Description Article模块启动主类
 * @Date 2020/11/24
 * @Version 1.0
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.soft1851.article.mapper")
@ComponentScan({"com.soft1851" ,"org.n3r.idworker"})
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
