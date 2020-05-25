package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel(value = "SalePlan",description = "销售计划")
@TableName("tbl_sale_plan")

public class SalePlan implements Serializable {
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