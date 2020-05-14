package org.fjh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@ApiModel(value = "Role", description = "角色")
@Data
public class Role {
    private String id;

    private Date updatedate;

    private Date createdate;

    @ApiModelProperty("角色名")
    private String name;
    @ApiModelProperty("角色描述")
    private String memo;
    @ApiModelProperty("拥有此角色的用户")
    private List<User> users;
    @ApiModelProperty("角色标签")
    private String tag;
}