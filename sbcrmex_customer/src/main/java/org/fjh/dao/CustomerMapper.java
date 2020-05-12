package org.fjh.dao;

import org.fjh.entity.Customer;
import org.fjh.entity.CustomerExample;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CustomerMapper extends BaseMapper<Customer, CustomerExample> {

    public List lostListPage(Map params);
}