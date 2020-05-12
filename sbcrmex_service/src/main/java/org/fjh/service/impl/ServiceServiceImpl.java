package org.fjh.service.impl;

import org.fjh.dao.ServiceMapper;
import org.fjh.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceServiceImpl extends BaseServiceImpl<org.fjh.entity.Service> implements IServiceService {


    private ServiceMapper serviceMapper;

    @Autowired
    public void setServiceMapper(ServiceMapper serviceMapper) {
        super.setBaseMapper(serviceMapper);
        this.serviceMapper = serviceMapper;
    }

    @Override
    public int updateBatchFiles(String[] sids) {
        return 0;//serviceMapper.updateFilesStatus(sids, "4");
    }
}
