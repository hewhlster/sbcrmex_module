package org.fjh.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.fjh.dao.RoleMapper;
import org.fjh.entity.Resource;
import org.fjh.entity.Role;
import org.fjh.entity.RoleExample;
import org.fjh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class RoleServiceImpl
        extends BaseServiceImpl<Role>
        implements IRoleService {


    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        super.setBaseMapper(roleMapper);
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.selectList(null);
    }

    @Override
    public Integer addRole(Role role) {
        return null;
    }

    @Override
    public Integer updateById(Role role) {
        return null;
    }



/*    @Override
    public Page<Role> pager(String url, Integer currentpage, Map<String, Object> params) {
        Page<Role> page = new Page<Role>();
        page.setUrl(url);
        page.setCurrentpage(currentpage);
        page.setParams(params);

        int rows = roleMapper.getTotal(null);//得到总记录数
        int pages = (rows % page.getPagerows() == 0) ? (rows / page.getPagerows()) : (rows / page.getPagerows() + 1);
        page.setPages(pages);//得到总页数
        int start = (page.getCurrentpage() - 1) * page.getPagerows();
        int end = (page.getCurrentpage()) * page.getPagerows();

        List<Role> data = roleMapper.pager(start, end, page.getParams());

        page.setData(data);
        return page;
    }*/

    @Override
    public Integer deleteById(String id) {
        // 先删除角色和资源中间的数据
        roleMapper.deleteRoleResourceById(id);
        // TODO Auto-generated method stub
        return roleMapper.deleteById(id);
    }

    @Override
    public Integer updateRoleResourceById(String id, String[] rids) {
        int ret = 0;
        // 先删除角色和资源中间的数据
        ret = roleMapper.deleteRoleResourceById(id);

        if (rids != null) {
            //插入中间表间数据
            ret = roleMapper.insertRoleResource(id, rids);
        }
        return ret;
    }

    @Override
    public List<Role> getRolesByUid(String id) {
        return roleMapper.selectUserRolesByUid(id);
    }

    @Override
    public List<Resource> getResourcesByUid(String id) {
        //根据用户得到其角色
       // User user = userMapper.selectByPrimaryKey(id);
      //  String rid = user.getUsersRid();
       // List<Resource> resources = roleMapper.getResourcesByRid(rid);
        //依据角色到其资源
        return null;//resources;
    }

}
