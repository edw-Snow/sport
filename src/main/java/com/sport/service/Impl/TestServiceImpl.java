package com.sport.service.Impl;

import com.sport.mapper.TestMapper;
import com.sport.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

}
