package org.fjh.action;

import com.alibaba.fastjson.JSONObject;
import org.fjh.entity.Role;
import org.fjh.entity.SaleChance;
import org.fjh.service.IResourceService;
import org.fjh.service.IRoleService;
import org.fjh.util.PageEntity;
import org.fjh.util.TreeNode;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
@RequestMapping("/role")
public class RoleAction extends BaseAction {

    private Logger logger = LoggerFactory.getLogger(RoleAction.class);

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourceService;

    /**
     * 用途：取得所有角色
     * 作者：樊建华
     * 日期：2019年1月17日-上午10:44:25
     */
    @RequestMapping("/role_list")
    public @ResponseBody
    List<Role> getAllRole() {
        return roleService.getAll();
    }

    @RequestMapping("/role_pager")
    public @ResponseBody
    Map pager(@RequestBody Object param) {
        PageEntity<Role> pageEx = super.bindPagerParams(param);

        PageEntity<Role> ret = roleService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }


    /**
     * 用途：返回系统所有角色列表（JSON格式）
     * 作者：樊建华
     * 日期：2017年12月20日-上午10:33:48
     */
    @RequestMapping("/list")
    public @ResponseBody
    List<Role> list() {
        return roleService.getAll();
    }

    /**
     * 用途：返回角色视图
     * 作者：樊建华
     * 日期：2019年1月15日-上午10:41:16
     */
    @RequestMapping("/role_view")
    public String roleView() {
        return "role/role_view";
    }

    /**
     * 用途：增加角色
     * 作者：樊建华
     * 日期：2019年1月15日-上午11:39:41
     */
    @RequestMapping("/role_add")
    public @ResponseBody
    Map roleAdd(Role role) {
        logger.info(role.toString());
        Integer ret = roleService.insertSelective(role);
        Map map = new HashMap();
        if (ret > 0)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：增加角色
     * 作者：樊建华
     * 日期：2019年1月15日-上午11:39:41
     */
    @RequestMapping("/role_update")
    public @ResponseBody
    Map roleUpdate(Role role) {
        Integer ret = roleService.updateByPrimaryKeySelective(role);
        Map map = new HashMap();
        if (ret > 0)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：增加角色
     * 作者：樊建华
     * 日期：2019年1月15日-上午11:39:41
     */
    @RequestMapping("/role_delete")
    public @ResponseBody
    Map roleDelete(String id) {
        Serializable ret = roleService.deleteById(id);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月16日-下午2:44:50
     */
    @RequestMapping("/role_resoure_update")
    public @ResponseBody
    Map roleResoureUpdate(String id, String[] rids) {
        Serializable ret = roleService.updateRoleResourceById(id, rids);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：返回资源菜单的JSON数据（编辑权限用）
     * 作者：樊建华
     * 日期：2019年1月18日-上午10:57:14
     */
    @RequestMapping("/get_resource_by_rid")
    @ResponseBody
    public TreeNode getResourceByRid(String rid) {
        TreeNode root = resourceService.getResourceConvertToTreeByRid(rid);
        //只返回除根结点外的数据
        return root;
    }

}
