package org.fjh.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "SaleChance", description = "销售机会")
public class SaleChance {
    private String id;

    private Date createdate;

    private Date updatedate;

    private String source;

    private String cname;

    private String lname;

    private String ltel1;

    private String ltel2;

    private String caddr;

    private String summay;

    private String detail;

    private String cuid;

    private String auid;

    private String duid;

    private String status;

}