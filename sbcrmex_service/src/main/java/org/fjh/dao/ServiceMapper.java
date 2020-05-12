package org.fjh.dao;

import org.fjh.entity.Service;
import org.fjh.entity.ServiceExample;
import org.springframework.stereotype.Component;

@Component
public interface ServiceMapper extends BaseMapper<Service, ServiceExample> {
}