package com.global.mybatis.blog;

import com.global.mybatis.blog.BlogInfoDto;

public interface BlogInfoDtoMapper {
    int deleteByPrimaryKey(Integer blogId);

    int insert(BlogInfoDto record);

    int insertSelective(BlogInfoDto record);

    BlogInfoDto selectByPrimaryKey(Integer blogId);

    int updateByPrimaryKeySelective(BlogInfoDto record);

    int updateByPrimaryKey(BlogInfoDto record);
}