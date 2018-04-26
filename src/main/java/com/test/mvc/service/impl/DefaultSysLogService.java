package com.test.mvc.service.impl;

import com.test.mvc.domain.SysLog;
import com.test.mvc.mapper.SysLogMapper;
import com.test.mvc.service.ISysLogService;
import com.test.mvc.domain.SysLog;
import com.test.mvc.mapper.SysLogMapper;
import com.test.mvc.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/6.
 */
@Service
public class DefaultSysLogService implements ISysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void addSysLog(SysLog sysLog) {
        sysLogMapper.addSysLog(sysLog);
    }
}
