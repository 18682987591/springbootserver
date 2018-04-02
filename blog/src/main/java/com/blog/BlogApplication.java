package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 *
 * @author troy
 * @date 2018/03/31
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.blog","com.global.config.blog","com.global.config.user"})
@MapperScan("com.global.mybatis.*")
@ServletComponentScan(basePackages= {"com.blog","com.global.servlet","com.global.filter"})
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
