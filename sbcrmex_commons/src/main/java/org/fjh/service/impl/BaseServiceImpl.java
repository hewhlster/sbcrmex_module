package org.fjh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.fjh.dao.BaseMapper;
import org.fjh.service.IBaseService;
import org.fjh.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: BaseServiceImpl.java<／p>
 * <p>Description:分页服务 <／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年2月27日
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    private BaseMapper baseMapper;

    public void setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    public PageEntity pagerEx(PageEntity<T> pageEntity) {
        Page page = PageHelper.startPage(pageEntity.getPageNumber(), pageEntity.getPageSize());
        List rows = baseMapper.listPage(pageEntity.getParams());
        pageEntity.setRows(rows);
        Long total = page.getTotal();
        pageEntity.setTotal(total.intValue());
        return pageEntity;
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return (T) baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insertSelective(record);
    }

    @Override
    public int insert(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateByPrimaryKeySelective(record);
    }
}
