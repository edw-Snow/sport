package com.sport.controller.v1;

import com.sport.common.result.PageResult;
import com.sport.common.result.Result;
import com.sport.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/queryProject")
    public Result<PageResult> queryProject(Integer pageNum,Integer pageSize){
        PageResult pageResult = projectService.queryProject(pageNum, pageSize);
        return Result.success(pageResult);
    }
}
