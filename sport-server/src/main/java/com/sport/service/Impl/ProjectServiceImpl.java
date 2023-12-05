package com.sport.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sport.entity.Project;
import com.sport.result.PageResult;
import com.sport.result.Result;
import com.sport.mapper.ProjectMapper;
import com.sport.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Result<PageResult> queryProject(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Project> projects = projectMapper.queryProject();
        PageResult pageResult = new PageResult(projects.getTotal(), projects.getResult());
        return Result.success(pageResult);
    }
}
