package com.sport.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sport.common.pojo.entity.Project;
import com.sport.common.result.PageResult;
import com.sport.mapper.ProjectMapper;
import com.sport.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public PageResult queryProject(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Project> projects = projectMapper.queryProject(pageNum, pageSize);
        return new PageResult(projects.getTotal(),projects.getResult());
    }
}
