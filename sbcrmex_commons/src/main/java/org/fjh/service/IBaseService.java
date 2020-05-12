package org.fjh.service;

import io.swagger.annotations.Api;
import org.fjh.util.PageEntity;

@Api("服务基类")
public interface IBaseService<T> {
    T selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int insertSelective(T record);

    int insert(T record);

    int updateByPrimaryKey(T record);

    int updateByPrimaryKeySelective(T record);

    PageEntity<T> pagerEx(PageEntity<T> pageEntity);
}
