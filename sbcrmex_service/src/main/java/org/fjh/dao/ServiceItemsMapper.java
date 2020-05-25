package org.fjh.dao;

import org.fjh.entity.ServiceItems;
import org.fjh.entity.ServiceItemsExample;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

@Component
public interface ServiceItemsMapper extends BaseMapper<ServiceItems> {
    /**
    * @方法名:selectBySid
    * @作用:根据服务ID取得服务项目列表
    * @作者:樊建华
    * @生成日期:2019/9/4 15:20
    * @参数:[sid]
    * @返回值:
    */
    public default  List<ServiceItems> selectBySid(String sid){return null;};
}