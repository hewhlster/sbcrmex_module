package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ServiceType", description = "服务类型")
@TableName("tbl_service_type")

public class ServiceType implements Serializable {
    private String id;

    private Date createdate;

    private Date updatedate;

    @ApiModelProperty("服务类型名称")
    private String name;
    @ApiModelProperty("服务类型详细描述")
    private String memo;

}