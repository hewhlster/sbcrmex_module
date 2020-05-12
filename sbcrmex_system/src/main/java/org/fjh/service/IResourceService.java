package org.fjh.service;

import org.fjh.entity.Resource;
import org.fjh.util.TreeNode;

import java.util.List;
import java.util.Map;


/**
 * 作用： 版本信息： 日期：2019年1月14日-下午9:41:20 版权:樊建华
 */

public interface IResourceService extends IBaseService<Resource> {
    //public Map<Resource, List<Resource>> getMenu(String rid);
    public Map<Resource, List<Resource>> getMenuByRid(String rid);

    public List<TreeNode> getMenuByRidEx(String rid);
    //public ArrayList<Map<Object, Object> > getTreeListByRid(String id);
    //public ArrayList<TreeNode> getNodes() ;
    //public ArrayList<Map<Object, Object> >getTreeList();

    public List<Resource> getResourceListByRid(String rid);

    public TreeNode getResourceConvertToTreeByRid(String rid);

    public TreeNode getAllResourceConvertToTree();

    public Integer deleteById(String id);

    public List<Resource> selectAll();
}
