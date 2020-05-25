package org.fjh.dao;

import org.fjh.entity.Customer;
import org.fjh.entity.CustomerExample;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Component
public interface CustomerMapper extends BaseMapper<Customer> {

    public List lostListPage(Map params);
}