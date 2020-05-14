package org.fjh.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel(value = "SalePlan",description = "销售计划")
public class SalePlan {
    private String id;

    private Date createdate;

    private Date modifydate;

    private String cid;

    private String cuid;

    private String auid;

    private Date acreatedate;

    private String duid;

    private String dcreatedate;

    private Integer status;

    private String result;

}