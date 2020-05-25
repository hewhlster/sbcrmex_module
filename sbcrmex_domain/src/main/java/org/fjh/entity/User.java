package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel(value = "User",description = "系统操作者")
@TableName("tbl_user")
public class User implements Serializable {
    private String id;

    private Date createdate;

    private Date updatedate;

    @NotNull
    @Length(min = 6,max = 6,message = "帐号为6位")
    @ApiModelProperty("帐号")
    private String code;
    @NotNull
    @Length(min = 2,max = 8,message = "姓名长度2-8位")
    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("密码")
    @NotNull
    @Length(min = 2,max = 8,message = "密码长度2-8位")
    private String password;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("联系电话")
    private String tel;
    @ApiModelProperty("联系地址")
    private String addr;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("帐号状态")
    private String state;

    @ApiModelProperty("角色(一个用户可拥有多个角色)")
    @TableField(exist = false)
    private List<Role> roles;

    @ApiModelProperty("电子邮箱")
    @Email(message = "邮件格式不对，例:hewlh@163.com")
    private String email;
    @ApiModelProperty("手机号")
    @Pattern(regexp = "",message = "手机格式不对")
    private String moblie;

}