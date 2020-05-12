package org.fjh.service;

import org.fjh.entity.Customer;
import org.fjh.util.PageEntity;

/**
 * ICustomerService
 * 版本信息：
 * 日期：2017年12月19日-上午11:23:29
 * 版权:樊建华
 */

public interface ICustomerService extends IBaseService<Customer> {
    public PageEntity<Customer> lostPager(PageEntity<Customer> pageEntity);

    public Integer confirmLostCustomer(String cid);
}
