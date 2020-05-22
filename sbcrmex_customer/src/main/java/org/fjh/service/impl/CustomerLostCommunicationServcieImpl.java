package org.fjh.service.impl;

import org.fjh.dao.CustomerLostCommunicationMapper;
import org.fjh.entity.CustomerLostCommunication;
import org.fjh.service.IBaseService;
import org.fjh.service.ICustomerLostCommunicationServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

@Service
public class CustomerLostCommunicationServcieImpl extends BaseServiceImpl<CustomerLostCommunication> implements ICustomerLostCommunicationServcie {


    private CustomerLostCommunicationMapper customerLostCommunicationMapper;

    @Autowired
    public void setCustomerLostCommunicationMapper(CustomerLostCommunicationMapper customerLostCommunicationMapper) {
        super.setBaseMapper(customerLostCommunicationMapper);
        this.customerLostCommunicationMapper = customerLostCommunicationMapper;
    }



}
