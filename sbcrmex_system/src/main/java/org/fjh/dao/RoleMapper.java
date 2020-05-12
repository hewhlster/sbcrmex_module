package org.fjh.dao;

import org.apache.ibatis.annotations.Param;
import org.fjh.entity.Role;
import org.fjh.entity.RoleExample;
import org.springframework.stereotype.Component;

@Component
public interface RoleMapper extends BaseMapper<Role, RoleExample> {
    public Role selectRoleUsersByPk(String pk);

    public Integer deleteRoleResourceById(@Param("id") String id);
    public Integer insertRoleResource(@Param("id") String id, @Param("rids") String[] rids);

}