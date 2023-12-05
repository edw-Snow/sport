package com.sport.service;

import com.sport.result.PageResult;
import com.sport.result.Result;

public interface ProjectService {

    Result<PageResult> queryProject(Integer pageNum, Integer pageSize);
}
