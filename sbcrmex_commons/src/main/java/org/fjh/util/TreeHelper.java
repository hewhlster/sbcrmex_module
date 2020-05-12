package org.fjh.util;

import com.alibaba.fastjson.annotation.JSONField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 作用： 版本信息： 日期：2019年1月18日-上午12:04:16 版权:樊建华
 */

public class TreeHelper {
    private Logger logger = LoggerFactory.getLogger(TreeHelper.class);

    private TreeNode root;//根结点

    private List<TreeNode> tempNodeList;//结点列表

    private boolean isValidTree = true;//是否是颗有效树

    //@Value("resource_root_parentid")
    private final String rootId = "fanjianhua";//根点的ID

    public TreeHelper() {
    }

    /**
     * 生成助手类实例后马上将结点列表生成树
     *
     * @param treeNodeList
     */
    public TreeHelper(List<TreeNode> treeNodeList) {
        this.tempNodeList = treeNodeList;
        generateTree();
    }

    public static TreeNode getTreeNodeById(TreeNode tree, String id) {
        if (tree == null)
            return null;
        TreeNode treeNode = tree.findTreeNodeById(id);
        return treeNode;
    }

    /**
     * generate a tree from the given treeNode or entity list
     */
    public void generateTree() {
        HashMap nodeMap = putNodesIntoMap();
        putChildIntoParent(nodeMap);
    }

    /**
     * <p>Description:将列表转成MAP,key为结点的ID，value为其值） <／p>
     *
     * @author 樊建华
     * @date 2019年3月11日
     */
    protected HashMap putNodesIntoMap() {
        int maxId = Integer.MAX_VALUE;
        LinkedHashMap nodeMap = new LinkedHashMap<String, TreeNode>();
        Iterator it = tempNodeList.iterator();
        while (it.hasNext()) {
            TreeNode treeNode = (TreeNode) it.next();
            String parentid = treeNode.getParentid();
            //if (parentid.equals("0")) {// 父结点
            if (parentid.equals(this.rootId)) {
                // maxId = id;
                this.root = treeNode;
            }
            String id = treeNode.getId();
            String keyId = String.valueOf(id);
            nodeMap.put(keyId, treeNode);
            //logger.info("keyId: " + keyId);
        }
        return nodeMap;
    }

    /**
     * set the parent nodes point to the child nodes
     *
     * @param nodeMap a hashmap that contains all the treenodes by its id as the key
     */
    protected void putChildIntoParent(HashMap nodeMap) {
        Iterator it = nodeMap.values().iterator();
        while (it.hasNext()) {
            TreeNode treeNode = (TreeNode) it.next();
            String parentId = treeNode.getParentid();
            String parentKeyId = String.valueOf(parentId);
            if (nodeMap.containsKey(parentKeyId)) {
                TreeNode parentNode = (TreeNode) nodeMap.get(parentKeyId);
                if (parentNode == null) {
                    this.isValidTree = false;
                    return;
                } else {
                    treeNode.setParentnode(parentNode);
                    parentNode.addChildNode(treeNode);
                    //logger.info("childId: " + treeNode.getId() + " parentId:" + parentNode.getParentid());
                }
            }
        }
    }

    /**
     * initialize the tempNodeList property
     */
    protected void initTempNodeList() {
        if (this.tempNodeList == null) {
            this.tempNodeList = new ArrayList<TreeNode>();
        }
    }

    /**
     * add a tree node to the tempNodeList
     */
    public void addTreeNode(TreeNode treeNode) {
        initTempNodeList();
        this.tempNodeList.add(treeNode);
    }

    /**
     * insert a tree node to the tree generated already
     *
     * @return show the insert operation is ok or not
     */
    public boolean insertTreeNode(TreeNode treeNode) {
        boolean insertFlag = root.insertJuniorNode(treeNode);
        return insertFlag;
    }

    /**
     * adapt the entities to the corresponding treeNode
     *
     * @param entityList list that contains the entities
     * @return the list containg the corresponding treeNodes of the entities
     */
    public static List<TreeNode> changeEnititiesToTreeNodes(List entityList) {
        OrganizationEntity orgEntity = new OrganizationEntity();
        List<TreeNode> tempNodeList = new ArrayList<TreeNode>();
        TreeNode treeNode;

        Iterator it = entityList.iterator();
        while (it.hasNext()) {
            orgEntity = (OrganizationEntity) it.next();
            treeNode = new TreeNode();
            treeNode.setObj(orgEntity);
            treeNode.setParentid(orgEntity.getParentId());
            treeNode.setId(orgEntity.getOrgId());
            treeNode.setName(orgEntity.getOrgName());
            tempNodeList.add(treeNode);
        }
        return tempNodeList;
    }

    @JSONField(serialize = false)
    public boolean isValidTree() {
        return this.isValidTree;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<TreeNode> getTempNodeList() {
        return tempNodeList;
    }

    public void setTempNodeList(List<TreeNode> tempNodeList) {
        this.tempNodeList = tempNodeList;
    }

}
