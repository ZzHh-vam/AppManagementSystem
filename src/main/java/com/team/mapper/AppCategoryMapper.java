package com.team.mapper;

import com.team.pojo.AppCategory;
import com.team.pojo.AppCategoryExample;
import java.util.List;

public interface AppCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}