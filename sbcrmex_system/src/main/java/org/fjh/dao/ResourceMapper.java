package org.fjh.dao;

import org.apache.ibatis.annotations.Param;
import org.fjh.entity.Resource;
import org.fjh.entity.ResourceExample;
import org.fjh.entity.Role;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Component
public interface ResourceMapper extends BaseMapper<Resource> {
    List<HashMap<String, Object>>  selectResourceByRidEx(String id);
    List<Resource> selectResourceByRid(String id);

    List<Resource> selectResourcesByRids(@Param("ids")String ids[]);
}