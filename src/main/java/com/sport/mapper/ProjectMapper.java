package com.sport.mapper;

import com.github.pagehelper.Page;
import com.sport.common.pojo.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProjectMapper {

    @Select("select * from project")
    Page<Project> queryProject(Integer pageNum, Integer pageSize);
}
