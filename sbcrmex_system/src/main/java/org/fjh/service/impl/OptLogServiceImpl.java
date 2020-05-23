package org.fjh.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.fjh.dao.OptLogMapper;
import org.fjh.entity.OptLog;
import org.fjh.service.IOptlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>Title: LogServiceImpl.java<／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年1月27日
 */
//@Transactional
@Service
@Component
public class OptLogServiceImpl
        extends BaseServiceImpl<OptLog>
        implements IOptlogService {

    private OptLogMapper logMapper;

    @Autowired
    public void setLogMapper(OptLogMapper logMapper) {
        super.setBaseMapper(logMapper);
        this.logMapper = logMapper;
    }

}
