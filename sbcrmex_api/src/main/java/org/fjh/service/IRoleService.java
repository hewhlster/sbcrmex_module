package org.fjh.service;

import org.fjh.entity.Resource;
import org.fjh.entity.Role;

import java.util.List;

public interface IRoleService extends IBaseService<Role> {
    public List<Role> getAll();

    public Integer addRole(Role role);

    public Integer updateById(Role role);

    public Integer deleteById(String id);

    /**
     * 用途：根据角色ID更新对应的资源
     * 作者：樊建华
     * 日期：2019年1月16日-下午2:46:51
     */
    public Integer updateRoleResourceById(String id, String[] rids);

    public List<Resource> getResourcesByUid(String id);

     List<Role> getRolesByUid(String id);
}
