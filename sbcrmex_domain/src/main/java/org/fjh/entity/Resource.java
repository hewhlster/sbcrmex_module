package org.fjh.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.fjh.util.TreeNode;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "SaleChance", description = "待授权的资源")
public class Resource extends TreeNode implements Serializable {
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

    private String memo;

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

}