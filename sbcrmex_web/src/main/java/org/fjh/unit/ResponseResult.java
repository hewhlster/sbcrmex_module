package org.fjh.unit;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Classname ResponseResult
 * @Description 返回结果
 * @Date 2020/5/16 8:42
 * @Created by Jack
 */
@Data
@ApiModel(value = "ResponseResult",description = "统一访回类")
public class  ResponseResult {

    @ApiModelProperty("响应code")
    private String code;
    @ApiModelProperty("响应消息")
    private String message;
    @ApiModelProperty("响应数据")
    private Object data;
    @ApiModelProperty("响应时间")
    //@JSONField(format = "")
    private Date date;


    ResponseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    ResponseResult(Object data) {
        this.data = data;
    }

    public static ResponseResult ok(Object data){
        ResponseResult success=new ResponseResult(data);
        success.setCode("10000");
        success.setMessage("操作成功");
        success.setDate(new Date());
        return success;
    }

    public static ResponseResult ng(Object data){
        return         ng("10001","操作失败(统一失败编号)",data);
    }

    public static ResponseResult ng(String code,Object data){
        return         ng(code,"操作失败",data);
    }

    public static ResponseResult ng(String code,String message, Object data){
        ResponseResult ng=new ResponseResult(code,message,data);
        ng.setDate(new Date());
        return ng;
    }
}
