package com.blog.controller;

import com.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 博客业务控制层
 *
 * @author troy
 * @date 2018/03/31
 */
@Controller
public class BlogController {

    @Autowired
    BlogService service;

    @RequestMapping("/login")
    public String Login() {
        return "/login";
    }

    @RequestMapping("/main")
    public String Main() {
        return "/blog";
    }

    @RequestMapping("/checkuser")
    public String CheckUser(@RequestParam("account") String account,@RequestParam("password") String password) {
        if("aaa".equals(account) && "aaa".equals(password)){
            return "/blog";
        }else{
            return "error";
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return service.insertBlogInfo("").toString();
    }
}
