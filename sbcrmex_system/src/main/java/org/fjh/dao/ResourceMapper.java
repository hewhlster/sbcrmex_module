package org.fjh.dao;

import org.fjh.entity.Resource;
import org.fjh.entity.ResourceExample;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface ResourceMapper extends BaseMapper<Resource, ResourceExample> {
    List<HashMap<String, Object>>  selectResourceByRidEx(String id);
    List<Resource> selectResourceByRid(String id);
}