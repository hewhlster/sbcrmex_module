package org.fjh.action;

import org.fjh.entity.Role;
import org.fjh.service.IResourceService;
import org.fjh.service.IRoleService;
import org.fjh.util.ResponseResult;
import org.fjh.util.PageEntity;
import org.fjh.util.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    ResponseResult pager(@RequestBody Object param) {
        PageEntity<Role> pageEx = super.bindPagerParams(param);

        PageEntity<Role> ret = roleService.pagerEx(pageEx);
        return ResponseResult.ok(ret);
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
    ResponseResult roleAdd(Role role) {
        logger.info(role.toString());
        Integer ret = roleService.insertSelective(role);
        if (ret > 0)
            return ResponseResult.ok();
        else
            return ResponseResult.ng("增加角色失败.",null);
    }

    /**
     * 用途：增加角色
     * 作者：樊建华
     * 日期：2019年1月15日-上午11:39:41
     */
    @RequestMapping("/role_update")
    public @ResponseBody
    ResponseResult roleUpdate(Role role) {
        Integer ret = roleService.updateByPrimaryKeySelective(role);

        return ResponseResult.ok(ret);
    }

    /**
     * 用途：增加角色
     * 作者：樊建华
     * 日期：2019年1月15日-上午11:39:41
     */
    @RequestMapping("/role_delete")
    public @ResponseBody
    ResponseResult roleDelete(String id) {
        Serializable ret = roleService.deleteById(id);
        if (ret != null)
            return ResponseResult.ok();
        else
            return ResponseResult.ng("20000","删除角色失败");
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
