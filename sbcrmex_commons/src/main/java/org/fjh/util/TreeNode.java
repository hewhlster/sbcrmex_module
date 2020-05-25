package org.fjh.util;

import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月17日-下午11:58:46
 * 版权:樊建华
 */


public class TreeNode  implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -7828156806800297334L;
    /**
     *
     */
    @JSONField(serialize = false)
    private static Logger logger = LoggerFactory.getLogger(TreeNode.class);
    //@JSONField(serialize=false)
    private String parentid; //父ID
    //@JSONField(serialize=false)
    private String id;  //自身ID
    //@JSONField(serialize=false)
    private String name;  //结点名称
    //@JSONField(serialize=false)
    private Boolean leaf;//是否叶子结点
    private TreeNode parentnode;  //父亲结点
    @JSONField(name = "children")
    private List<TreeNode> childList;  //子结点列表

    protected Object obj;

    private Boolean isChecked;

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    public TreeNode() {
        initChildList();
    }

    public TreeNode(TreeNode parentNode) {
        this.getParentnode();
        initChildList();
    }

    @JSONField(serialize = false)
    public boolean isLeaf() {
        if (childList == null) {
            return true;
        } else {
            if (childList.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    /* 插入一个child节点到当前节点中 */
    public void addChildNode(TreeNode treeNode) {
        initChildList();
        childList.add(treeNode);
    }

    /**
     * <p>Description:初始化子结点列表 <／p>
     *
     * @author 樊建华
     * @date 2019年3月11日
     */
    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<TreeNode>();
    }

    public boolean isValidTree() {
        return true;
    }

    @JSONField(serialize = false)
    /**
     *  返回当前节点的父辈节点集合
     *  */
    public List<TreeNode> getElders() {
        List<TreeNode> elderList = new ArrayList<TreeNode>();
        TreeNode parentNode = this.getParentnode();
        if (parentNode == null) {
            return elderList;
        } else {
            elderList.add(parentNode);
            elderList.addAll(parentNode.getElders());
            return elderList;
        }
    }

    @JSONField(serialize = false)
    /**
     *  返回当前节点的晚辈集合 */
    public List<TreeNode> getJuniors() {
        List<TreeNode> juniorList = new ArrayList<TreeNode>();
        List<TreeNode> childList = this.getChildList();
        if (childList == null) {
            return juniorList;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode junior = childList.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }

    /* 返回当前节点的孩子集合 */
    public List<TreeNode> getChildList() {
        return childList;
    }

    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        TreeNode parentNode = this.getParentnode();
        String id = this.getId();

        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    }

    /* 删除当前节点的某个子节点 */
    public void deleteChildNode(String childId) {
        List<TreeNode> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }

    /* 动态的插入一个新的节点到当前树中 */
    public boolean insertJuniorNode(TreeNode treeNode) {
        String juniorParentId = treeNode.getParentid();
        if (this.parentid.equals(juniorParentId)) {
            addChildNode(treeNode);
            return true;
        } else {
            List<TreeNode> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                TreeNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag == true)
                    return true;
            }
            return false;
        }
    }

    /* 找到一颗树中某个节点 */
    public TreeNode findTreeNodeById(String id) {
        if (this.id.equals(id))
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode child = childList.get(i);
                TreeNode resultNode = child.findTreeNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }

    /* 遍历一棵树，层次遍历 */
    public void traverse() {
        if (id == null)
            return;
        if (childList == null || childList.isEmpty())
            return;
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            child.traverse();
        }
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(serialize = false)
    public TreeNode getParentnode() {
        return parentnode;
    }

    public void setParentnode(TreeNode parentnode) {
        this.parentnode = parentnode;
    }

    public void setChildList(List<TreeNode> childList) {
        this.childList = childList;
    }

    @JSONField(serialize = false)
    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}

