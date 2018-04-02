package com.blog.service;

import com.global.mybatis.blog.BlogInfoDto;

/**
 * 博客业务接口
 *
 * @author troy
 * @date 2018/03/31
 */
public interface BlogService {
    BlogInfoDto getBlogInfo(Integer blogId);

    Integer insertBlogInfo(String blogInfoStr);
}
