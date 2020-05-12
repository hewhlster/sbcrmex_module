package org.fjh.entity;

import lombok.Data;
import org.fjh.util.TreeNode;

import java.util.Date;

@Data
public class Resource extends TreeNode{
    private String id;

    private Date createdate;

    private Date updatedate;

    private String name;

    private String url;

    private String pid;

    private Integer gnum;

    private Integer valid;

    private Integer type;

    private Integer level;

    private String icon;


    public Resource() {
    }

    public Resource(String id, Date createdate, Date updatedate, String name, String url, String pid, Integer gnum, Integer valid, Integer type, Integer level, String icon, String memo) {
        this.id = id;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.name = name;
        this.url = url;
        this.pid = pid;
        this.gnum = gnum;
        this.valid = valid;
        this.type = type;
        this.level = level;
        this.icon = icon;
        this.memo = memo;
    }

    private String memo;





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}