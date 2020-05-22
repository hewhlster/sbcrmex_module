package org.fjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fjh.dao.CustomerMapper;
import org.fjh.entity.Customer;
import org.fjh.service.ICustomerService;
import org.fjh.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

/**
 * CustomerServiceImpl
 * 版本信息：
 * 日期：2017年12月19日-上午11:25:26
 * 版权:樊建华
 */
@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements ICustomerService {

    private CustomerMapper customerMapper;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        super.setBaseMapper(customerMapper);
        this.customerMapper = customerMapper;
    }

    @Override
    public PageEntity<Customer> lostPager(PageEntity<Customer> pageEntity) {
        Page page = PageHelper.startPage(pageEntity.getPageNumber(), pageEntity.getPageSize());
        List rows = customerMapper.lostListPage(pageEntity.getParams());
        pageEntity.setRows(rows);
        Long total = page.getTotal();
        pageEntity.setTotal(total.intValue());
        return pageEntity;
    }


    @Override
    public Integer confirmLostCustomer(String cid) {
        Customer c = new Customer();
        c.setId(cid);
        c.setStatus("1");//修改状态为流失


        return updateByPrimaryKeySelective(c);
    }


}
