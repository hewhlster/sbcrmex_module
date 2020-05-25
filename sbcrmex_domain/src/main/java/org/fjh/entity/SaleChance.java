package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "SaleChance", description = "销售机会")
@TableName("tbl_sale_chance")

public class SaleChance implements Serializable {
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