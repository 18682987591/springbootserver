package com.blog.service;

import com.global.mybatis.blog.BlogInfoDto;
import com.global.mybatis.blog.BlogInfoDtoMapper;
import com.global.mybatis.user.UserInfoDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 博客业务实现类
 *
 * @author troy
 * @date 2018/03/31
 */
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private UserInfoDtoMapper userInfoDtoMapper;

    @Autowired
    private BlogInfoDtoMapper blogInfoDtoMapper;

    @Override
    public BlogInfoDto getBlogInfo(Integer blogId) {
        return blogInfoDtoMapper.selectByPrimaryKey(blogId);
    }

    @Override
    public Integer insertBlogInfo(String blogInfoStr) {
        BlogInfoDto blogInfoDto = new BlogInfoDto();
        blogInfoDto.setBlogName("第一个博客");
        blogInfoDto.setUserId(0);
        blogInfoDto.setBlogKeyword("第一");
        blogInfoDto.setBlogTitle("第一博客标题");
        blogInfoDto.setBlogDescription("第一博客描述");
        return blogInfoDtoMapper.insert(blogInfoDto);
    }
}
