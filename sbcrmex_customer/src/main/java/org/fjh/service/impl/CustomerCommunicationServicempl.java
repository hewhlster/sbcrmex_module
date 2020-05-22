package org.fjh.service.impl;


import org.apache.dubbo.config.annotation.Service;
import org.fjh.dao.CustomerCommunicationMapper;
import org.fjh.entity.CustomerCommunication;
import org.fjh.service.ICustomerCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerCommunicationServicempl extends BaseServiceImpl<CustomerCommunication> implements ICustomerCommunicationService {

    private CustomerCommunicationMapper customerCommunicationMapper;


    @Autowired
    public void setCustomerCommunicationMapper(CustomerCommunicationMapper customerCommunicationMapper) {
        super.setBaseMapper(customerCommunicationMapper);
        this.customerCommunicationMapper = customerCommunicationMapper;
    }




    @Override
    public Integer addCommunication(CustomerCommunication cc) {
        return customerCommunicationMapper.insertSelective(cc);
    }


}
