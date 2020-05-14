package org.fjh.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "User",description = "系统操作者")
public class User {
    private String id;

    private Date createdate;

    private Date updatedate;

    private String code;

    private String name;

    private String password;

    private String gender;

    private String tel;

    private String addr;

    private String remark;

    private String state;

    @ApiModelProperty("角色(一个用户可拥有多个角色)")
    private List<Role> roles;

    @ApiModelProperty("电子邮箱")
    private String email;
    @ApiModelProperty("手机号")
    private String moblie;

}