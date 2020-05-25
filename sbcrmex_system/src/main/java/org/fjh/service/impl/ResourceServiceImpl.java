package org.fjh.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.fjh.dao.ResourceMapper;
import org.fjh.dao.RoleMapper;
import org.fjh.entity.Resource;
import org.fjh.entity.ResourceExample;
import org.fjh.entity.Role;
import org.fjh.service.IResourceService;
import org.fjh.util.Menu;
import org.fjh.util.TreeHelper;
import org.fjh.util.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 作用： 版本信息： 日期：2019年1月14日-下午9:43:03 版权:樊建华
 */

@Service
//@CacheConfig(cacheNames = "resourceService") // 设置全局value = "resource"
public class ResourceServiceImpl
        extends BaseServiceImpl<Resource>
        implements IResourceService {
    private Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    private ResourceMapper resourceMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    public void setResourceMapper(ResourceMapper resourceMapper) {
        super.setBaseMapper(resourceMapper);
        this.resourceMapper = resourceMapper;
    }


    public List<Resource> getResourceListByRid(String rid) {
        return resourceMapper.selectResourceByRid(rid);
    }

    // 二层菜单结构
    @Override
    //@Cacheable(key = "#root.methodName+':'+#root.args[0]")
    public Map<Resource, List<Resource>> getMenuByRid(String rid) {
        List menus = getResourceListByRid(rid);
        // 生成树结点助手
        TreeHelper thelper = new TreeHelper(menus);
        TreeNode root = thelper.getRoot();
        Map map = new LinkedHashMap();// 保证有序
        List childList = root.getChildList();
        List<Resource> menuList = new ArrayList<Resource>();

        Iterator<Resource> iterator = childList.iterator();
        while (iterator.hasNext()) {
            Resource resource = iterator.next();
            menuList.add(resource);
        }

        Collections.sort(menuList, new Comparator<Resource>() {
            @Override
            public int compare(Resource o1, Resource o2) {
                return o1.getGnum()- o2.getGnum();
            }
        });

        for (Resource temp : menuList)
            map.put(temp, temp.getChildList());

        return map;
    }
	/*
	@Override
	public Map<Resource, List<Resource>> getMenu(String rid) {
		// JDK1.8以上
		// menus.forEach((p) -> {
		// if( !ret.containsKey(p)) {
		// ret.put(p, new ArrayList());
		// } else
		// ret.get(p).add(p);
		// });

		/*
		 * List<Resource> menus = getResourceListByRid(rid);
		 * 
		 * Map<Resource, List<Resource>> ret1 = new LinkedHashMap();// 保证有序 //
		 * 得到顶层菜单 for(Resource r:menus) { if( r.getAlevel()==1) { ret1.put(r,
		 * new ArrayList()); } } //将子菜单加入顶层菜单 for(Resource r1:menus) {
		 * Set<Resource> keyset = ret1.keySet(); for (Resource key : keyset) {
		 * if (key.getAid().equals(r1.getApid())) { ret1.get(key).add(r1);
		 * break; } } }
		 
		return null;

	}
*/
    /**
     *
     * 用途： 作者：樊建华 日期：2019年1月15日-下午9:36:20

     @Cacheable(value = "treeList")
     public ArrayList<Map<Object, Object>> getTreeList() {
     // 取得数据
     List<HashMap<Object, Object>> resultMap = resourceMapper.select();
     logger.info(resultMap.toString());
     // 定义一个Map集合 存储按指定顺序排列好的菜单
     Map<String, List<Map<Object, Object>>> temp = new HashMap<String, List<Map<Object, Object>>>();

     for (HashMap<Object, Object> map : resultMap) {
     // 如果temp的键包含这个parentid
     if (temp.containsKey(map.get("parentid").toString())) {
     // if(map.get("parentid")!=null ){

     // 那么把所有相同parentid的数据全部添加到该parentid键下
     // temp.get(map.get("parentid").toString()).add(map);
     temp.get(map.get("parentid").toString()).add(map);

     } else {
     // 初始化temp 第一次用
     List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
     list.add(map);
     temp.put(map.get("parentid").toString(), list);
     // temp.put(map.get("id").toString(), list);

     }
     }
     // 定义一个完整菜单列表
     ArrayList<Map<Object, Object>> array = new ArrayList<Map<Object, Object>>();

     for (HashMap<Object, Object> hashMap : resultMap) {
     // 如果temp中的键与当前id一致
     if (temp.containsKey(hashMap.get("id").toString())) {
     // 说明temp是当前id菜单的子菜单
     hashMap.put("nodes", temp.get(hashMap.get("id").toString()));
     }
     // 遇到顶级菜单就添加进完整菜单列表
     if (hashMap.get("parentid").toString().equals("0")) {
     array.add(hashMap);
     }
     }
     return array;
     }
     */
    /**
     * 将查询出的数据，转换成TreeNode的列表
     * <p>
     * public ArrayList<TreeNode> getNodes() {
     * // 取得数据
     * List<HashMap<Object, Object>> resultMap = resourceMapper.select();
     * logger.info(resultMap.toString());
     * ArrayList<TreeNode> array = new ArrayList<>();
     * for (HashMap<Object, Object> item : resultMap) {
     * TreeNode t = new TreeNode();
     * t.setId(item.get("id").toString());
     * t.setParentid(item.get("parentid").toString());
     * t.setName(item.get("text").toString());
     * array.add(t);
     * }
     * return array;
     * }
     */


    @Override
    public Integer deleteById(String id) {
        Integer ret = 0;
        // 最好用递归删除

        // 先删除子数据
        resourceMapper.deleteById(id);
        // 删除数据
        ret = resourceMapper.deleteById(id);

        return ret;
    }

    @Override
    public List<Resource> selectAll() {
        return resourceMapper.selectList(null);
    }



    /*
    private class State {

        private Boolean checked = false;
        private Boolean disabled = false;
        private Boolean expanded = false;
        private Boolean selected = false;

        public State() {
            super();
            // TODO Auto-generated constructor stub
        }

        public Boolean getChecked() {
            return checked;
        }

        public void setChecked(Boolean checked) {
            this.checked = checked;
        }

        public Boolean getDisabled() {
            return disabled;
        }

        public void setDisabled(Boolean disabled) {
            this.disabled = disabled;
        }

        public Boolean getExpanded() {
            return expanded;
        }

        public void setExpanded(Boolean expanded) {
            this.expanded = expanded;
        }

        public Boolean getSelected() {
            return selected;
        }

        public void setSelected(Boolean selected) {
            this.selected = selected;
        }
    }
    */
	/*
	public ArrayList<Map<Object, Object>> getTreeListByRid(String id) {
		// 取得数据
		List<HashMap<Object, Object>> resultMapA = resourceMapper.selectByRid(id);
		logger.info(resultMapA.toString());

		// 转换
		List<HashMap<Object, Object>> resultMap = new ArrayList<>();
		Iterator iterator = resultMapA.iterator();
		while (iterator.hasNext()) {
			HashMap<Object, Object> item = (HashMap<Object, Object>) iterator.next();
			
			  } for (HashMap<Object, Object> item : resultMapA) {
			 
			// 名为rid的key不为空，说明查询到些数据，有这个权限
			if (item.containsKey("rid")) {
				State state = new State();
				state.setChecked(true);
				item.put("state", state);
			}
			resultMap.add(item);
		}

		// 定义一个Map集合 存储按指定顺序排列好的菜单
		Map<String, List<Map<Object, Object>>> temp = new HashMap<String, List<Map<Object, Object>>>();

		for (HashMap<Object, Object> map : resultMap) {
			// 如果temp的键包含这个parentid
			if (temp.containsKey(map.get("parentid").toString())) {
				// if(map.get("parentid")!=null ){

				// 那么把所有相同parentid的数据全部添加到该parentid键下
				// temp.get(map.get("parentid").toString()).add(map);
				temp.get(map.get("parentid").toString()).add(map);

			} else {
				// 初始化temp 第一次用
				List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
				list.add(map);
				temp.put(map.get("parentid").toString(), list);
				// temp.put(map.get("id").toString(), list);

			}
		}
		// 定义一个完整菜单列表
		ArrayList<Map<Object, Object>> array = new ArrayList<Map<Object, Object>>();

		for (HashMap<Object, Object> hashMap : resultMap) {
			// 如果temp中的键与当前id一致
			if (temp.containsKey(hashMap.get("id").toString())) {
				// 说明temp是当前id菜单的子菜单
				hashMap.put("nodes", temp.get(hashMap.get("id").toString()));
			}
			// 遇到顶级菜单就添加进完整菜单列表
			if (hashMap.get("parentid").toString().equals("0")) {
				array.add(hashMap);
			}
		}
		return array;
	}
*/
    @Override
    //@Cacheable(key = "#root.methodName+':'+#root.args[0]")
    public TreeNode getResourceConvertToTreeByRid(String rid) {
        List<HashMap<String, Object>> resourcesList = resourceMapper.selectResourceByRidEx(rid);
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (HashMap<String, Object> temp : resourcesList) {
                TreeNode node = new Resource((String) temp.get("id"), (Date) temp.get("createdate"),
                    (Date) temp.get("updatedate"), (String) temp.get("name"), (String) temp.get("url"),
                    (String) temp.get("pid"), (Integer) temp.get("gnum"), (Integer) temp.get("valid"),
                    (Integer) temp.get("type"),
                    (Integer) temp.get("level"),
                    (String) temp.get("icon"), (String) temp.get("memo")
            );

            node.setId((String) temp.get("id"));
            node.setParentid((String) temp.get("pid"));
            node.setName((String) temp.get("name"));
            if (temp.get("rid") != null) {
                node.setIsChecked(true);
            } else
                node.setIsChecked(false);
            treeNodeList.add(node);
        }

        TreeHelper thelper = new TreeHelper(treeNodeList);

        return thelper.getRoot();
    }

    @Override
    public TreeNode getAllResourceConvertToTree() {
        // TODO Auto-generated method stub
        List<Resource> resourcesList = resourceMapper.selectList(null);

        List<TreeNode> treeNodeList = new ArrayList<>();
        for (Resource temp : resourcesList) {
            TreeNode tn = new Menu(temp.getId(), temp.getName(), temp.getIcon(), temp.getIcon());
            tn.setId(temp.getId());
            tn.setParentid(temp.getPid());
            tn.setName(temp.getName());
            treeNodeList.add(tn);
        }

        TreeHelper thelper = new TreeHelper(treeNodeList);

        return thelper.getRoot();
    }

    @Override
    public List<TreeNode> getMenuByRidEx(String rid) {
        List<Resource> list = getResourceListByRid(rid);
        List<TreeNode> treeNodeList = new ArrayList<>();

        for (Resource temp : list) {
            TreeNode tn = new Menu(temp.getId(), temp.getName(), temp.getUrl(), temp.getIcon());
            tn.setId(temp.getId());
            tn.setParentid(temp.getPid());
            tn.setName(temp.getName());
            treeNodeList.add(tn);
        }

        TreeHelper thelper = new TreeHelper(treeNodeList);

        return thelper.getRoot().getChildList();
    }

    @Override
    public List<TreeNode> getMenuByUidEx(String id) {
        //取得用户的所有角色
        List<Role> roles=roleMapper.selectUserRolesByUid(id);
        String ids[] = new String[roles.size()];
        for(int index=0;index<ids.length;index++){
            ids[index] = roles.get(index).getId();
        }
        //根据角色取得其对应的资源
        List<Resource> list = resourceMapper.selectResourcesByRids(ids);

        List<TreeNode> treeNodeList = new ArrayList<>();

        for (Resource temp : list) {
            if(temp==null)
                continue;
            TreeNode tn = new Menu(temp.getId(), temp.getName(), temp.getUrl(), temp.getIcon());
            tn.setId(temp.getId());
            tn.setParentid(temp.getPid());
            tn.setName(temp.getName());
            treeNodeList.add(tn);
        }

        TreeHelper thelper = new TreeHelper(treeNodeList);

        return thelper.getRoot().getChildList();
    }

}
