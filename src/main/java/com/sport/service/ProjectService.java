package com.sport.service;

import com.sport.common.result.PageResult;

public interface ProjectService {

    PageResult queryProject(Integer pageNum, Integer pageSize);
}
