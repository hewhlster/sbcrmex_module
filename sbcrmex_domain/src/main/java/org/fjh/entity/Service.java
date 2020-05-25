package org.fjh.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("服务")
@TableName("tbl_service")
public class Service implements Serializable {
    private String id;

    private Date createdate;

    private Date modifydate;

    private String cid;

    private String stid;

    private String summary;

    private String status;

    private String detail;

    private String cuid;

    private String fauid;

    private Date facreatetime;

    private String fduid;

    private Date fdcreatetime;

    private String fresult;

    private Integer fsatisfy;
    @ApiModelProperty("服务的客户")
    private Customer customer;//服务的客户
    @ApiModelProperty("创建者")
    private User cuser;//创建者
    @ApiModelProperty("服务满意调查指派者")
    private User fauser;//服务满意调查指派者
    @ApiModelProperty("服务满意调查实施者")
    private User fduser;//服务满意调查实施者
    @ApiModelProperty("具体服务项目")
    private List<ServiceItems> items;//具体服务项目

}