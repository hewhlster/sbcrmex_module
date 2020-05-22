package org.fjh.service.impl;

import org.fjh.dao.CustomerLinkmanMapper;
import org.fjh.entity.CustomerLinkman;
import org.fjh.service.ICustomerLinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月11日-下午2:13:48
 * 版权:樊建华
 */

@Service
public class CustomerLinkmanServiceImpl extends BaseServiceImpl<CustomerLinkman> implements ICustomerLinkmanService {

    private CustomerLinkmanMapper customerLinkmanMapper;

    @Autowired
    public void setCustomerLinkmanMapper(CustomerLinkmanMapper customerLinkmanMapper) {
        super.setBaseMapper(customerLinkmanMapper);
        this.customerLinkmanMapper = customerLinkmanMapper;
    }
}
