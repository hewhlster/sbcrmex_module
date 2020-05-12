package org.fjh.action;

import org.fjh.dao.ResourceMapper;
import org.fjh.entity.Resource;
import org.fjh.service.IResourceService;
import org.fjh.util.TreeNode;
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

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月15日-下午5:02:25
 * 版权:樊建华
 */

@Controller
@RequestMapping("/resource")
public class ResourceAtion extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(ResourceAtion.class);

    @Autowired
    private IResourceService resourceService;
	
	/*
	@GetMapping("/menu")
	public ModelAndView menu(HttpSession session,ModelAndView mv) {
		User user =(User) session.getAttribute("logineduser");
		//从session中取得当前登录的用户
		//从session中取得当前登录的用户
		Map map=resourceService.getMenu(user.getUsersRid());
		mv.addObject("menu", map);
		mv.setViewName("menu");
		return mv;
	}
	*/
/*	@GetMapping("/get")
	@ResponseBody
	public ArrayList<Map<Object,Object>> getResourceByRoleId(String id) {
			ArrayList<Map<Object,Object>> json=resourceService.getTreeListByRid(id);
	        return json;
	}*/

    /**
     * 用途：增加资源
     * 作者：樊建华
     * 日期：2019年1月16日-上午10:19:21
     */
    @GetMapping("/add")
    @ResponseBody
    public Map resourceAdd(Resource resource) {
        logger.info(resource.toString());
        Serializable ret = resourceService.insertSelective(resource);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：更新资源
     * 作者：樊建华
     * 日期：2019年1月16日-下午1:34:05
     */
    @GetMapping("/update")
    @ResponseBody
    public Map resourceUpdate(Resource resource) {
        logger.info(resource.toString());
        Serializable ret = resourceService.updateByPrimaryKeySelective(resource);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    /**
     * 用途：删除资源
     * 作者：樊建华
     * 日期：2019年1月16日-下午2:12:42
     */
    @GetMapping("/delete")
    @ResponseBody
    public Map resourceDelete(@RequestParam("id") String id) {
        Integer ret = resourceService.deleteById(id);
        Map map = new HashMap();
        if (ret > 0)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    @GetMapping("/resource_view")
    public String resouceView() {
        return "resource/resource_view";
    }

    @GetMapping("/resource_get_all")
    @ResponseBody
    public List<TreeNode> resourceGetTreeNode() {
        return resourceService.getAllResourceConvertToTree().getChildList();

    }

    /**
     * 前端由bootstarpTable换成bootstrapTreeTable
     */
    @Autowired
    ResourceMapper resourceMapper;

    @RequestMapping("/pager")
    public @ResponseBody
    List<Resource> pager() {
        return resourceService.selectAll();
    }
}
