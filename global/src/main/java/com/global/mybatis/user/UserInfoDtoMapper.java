package com.global.mybatis.user;

import com.global.mybatis.user.UserInfoDto;

public interface UserInfoDtoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfoDto record);

    int insertSelective(UserInfoDto record);

    UserInfoDto selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfoDto record);

    int updateByPrimaryKey(UserInfoDto record);
}