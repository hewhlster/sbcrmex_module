package org.fjh.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ServiceItems {
    private String id;

    private Date createdate;

    private Date updatedate;

    private String sid;

    private String auid;

    private Date acreatedate;

    private String amemo;

    private String duid;

    private Date dcreatedate;

    private String dresult;

    @ApiModelProperty("分配者")
    private User fduser;//
    @ApiModelProperty("实施者")
    private User duser;//

}