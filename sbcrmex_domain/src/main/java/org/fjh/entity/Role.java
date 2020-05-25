package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "Role", description = "角色")
@Data
@TableName("tbl_role")

public class Role implements Serializable {
    private String id;

    private Date updatedate;

    private Date createdate;

    @ApiModelProperty("角色名")
    private String name;
    @ApiModelProperty("角色描述")
    private String memo;
    @ApiModelProperty("拥有此角色的用户")
    @TableField(exist = false)
    private List<User> users;
    @ApiModelProperty("角色标签")
    private String tag;
}