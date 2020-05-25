package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "OptLog", description = "操作日志")
@TableName("tbl_opt_log")
public class OptLog implements Serializable {
    private String id;
    @ApiModelProperty("要操作的URL")
    private String url;
    @ApiModelProperty("操作者IP")
    private String ip;
    @ApiModelProperty("操作者")
    private String user;
    @ApiModelProperty("操作日期")
    private Date date;
    @ApiModelProperty("操作结果")
    private String ret;
    @ApiModelProperty("操作传入的参数")
    private String datas;

}