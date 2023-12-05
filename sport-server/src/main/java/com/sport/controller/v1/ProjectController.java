package com.sport.controller.v1;

import com.sport.result.PageResult;
import com.sport.result.Result;
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

    /**
     * 查询项目表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/queryProject")
    public Result<PageResult> queryProject(Integer pageNum,Integer pageSize){
        return projectService.queryProject(pageNum, pageSize);
    }
}
