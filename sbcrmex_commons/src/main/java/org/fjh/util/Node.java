package org.fjh.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 作用：树形节点模型 版本信息： 日期：2019年1月15日-下午5:09:07 版权:樊建华
 */

public class Node {
    private static Logger logger = LoggerFactory.getLogger(Node.class);

    private String nodeId; // 树的节点Id，区别于数据库中保存的数据Id。
    private String pid;
    private String text; // 节点名称
    private String icon;
    private String href; // 点击节点触发的链接
    private List<Node> nodes; // 子节点，可以用递归的方法读取


    private class State {

        private Boolean checked = true;
        private Boolean disabled;
        private Boolean expanded;
        private Boolean selected;


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

    private State state = new State();

//    private Map<String, Object> state;
//	private static Map<String, Object> stateMap = new HashMap<String, Object>();
//
//	static {
//		stateMap.put("checked", true);
//	}
//
//	public void setState() {
//		this.state = stateMap;
//	}
//
//	public Map<String, Object> getState() {
//		return state;
//	}

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node() {
        this.nodes = new ArrayList<Node>();
    }

    public Node(String nodeId, String pId) {
        this.nodeId = nodeId;
        this.pid = pId;
        this.nodes = new ArrayList<Node>();
    }

    /**
     * 生成一个节点
     *
     * @param nodeId
     * @param pId
     * @param text
     * @param icon
     * @param href
     */
    public Node(String nodeId, String pId, String text, String icon, String href) {
        super();
        this.nodeId = nodeId;
        this.pid = pId;
        this.text = text;
        this.icon = icon;
        this.href = href;
        this.nodes = new ArrayList<Node>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * 生成一颗多叉树，根节点为root
     *
     * @param Nodes 生成多叉树的节点集合
     * @return root
     */
    public Node createTree(List<Node> Nodes) {
        if (Nodes == null || Nodes.size() < 0)
            return null;
        Node root = new Node("root", "0");// 根节点自定义，但是要和pid对应好
        // 将所有节点添加到多叉树中
        for (Node node : Nodes) {
            if (node.getPid().equals("0") || node.getPid().equals("root")) {// 根节点自定义，但是要和pid对应好
                // 向根添加一个节点
                root.getNodes().add(node);
            } else {
                addChild(root, node);
            }
        }
        return root;
    }

    /**
     * 向指定多叉树节点添加子节点
     *
     * @param Node  多叉树节点
     * @param child 节点
     */
    public void addChild(Node Node, Node child) {
        for (org.fjh.util.Node item : Node.getNodes()) {
            if (item.getNodeId().equals(child.getPid())) {
                // 找到对应的父亲
                item.getNodes().add(child);
                break;
            } else {
                if (item.getNodes() != null && item.getNodes().size() > 0) {
                    addChild(item, child);
                }
            }
        }
    }

    /**
     * 遍历多叉树
     *
     * @param Node 多叉树节点
     * @return
     */
    public String iteratorTree(Node Node) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");
        if (Node != null) {
            for (org.fjh.util.Node index : Node.getNodes()) {
                buffer.append(index.getNodeId() + ",");
                if (index.getNodes() != null && index.getNodes().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }
        buffer.append("\n");
        return buffer.toString();
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node("系统管理", "0"));
        nodes.add(new Node("角色管理", "系统管理"));
        nodes.add(new Node("资源管理", "系统管理"));
        nodes.add(new Node("用户管理", "系统管理"));
        nodes.add(new Node("添加用户", "用户管理"));
        nodes.add(new Node("修改用户", "用户管理"));
        nodes.add(new Node("机票管理", "系统管理"));

        Node tree = new Node();
        Node mt = tree.createTree(nodes);
        //logger.info(tree.iteratorTree(mt));
    }

}
