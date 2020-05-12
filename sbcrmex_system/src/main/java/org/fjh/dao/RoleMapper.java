package org.fjh.dao;

import org.apache.ibatis.annotations.Param;
import org.fjh.entity.Role;
import org.fjh.entity.RoleExample;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper extends BaseMapper<Role, RoleExample> {
    public Role selectRoleUsersByPk(String pk);

    public Integer deleteRoleResourceById(@Param("id") String id);
    public Integer insertRoleResource(@Param("id") String id, @Param("rids") String[] rids);
    //2020/5/20
    List<Role> selectUserRolesByUid(@Param("id")String id);
}