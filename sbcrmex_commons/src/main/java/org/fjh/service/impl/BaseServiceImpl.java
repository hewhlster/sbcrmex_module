package org.fjh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fjh.service.IBaseService;
import org.fjh.util.PageEntity;
import java.util.Map;

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
     /*   Page page = PageHelper.startPage(pageEntity.getPageNumber(), pageEntity.getPageSize());
        List rows = baseMapper.listPage(pageEntity.getParams());
        pageEntity.setRows(rows);

        Long total = page.getTotal();
        pageEntity.setTotal(total.intValue());*/

        //使用mybatis-plus分页功能
        Page<T> page = new Page(pageEntity.getPageNumber(),pageEntity.getPageSize());
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        //增加查询条件
        for(Map.Entry<String,Object> entry:pageEntity.getParams().entrySet()){
            queryWrapper.eq(entry.getKey(),entry.getValue());
        }

        //开始分页
        baseMapper.selectPage(page,queryWrapper);
        //将结果转换成原来的格式
        pageEntity.setRows(page.getRecords());
        pageEntity.setTotal((int)page.getTotal());
        return pageEntity;
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return (T) baseMapper.selectById(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        // TODO Auto-generated method stub
        return baseMapper.deleteById(id);
    }

    @Override
    public int insertSelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insert(record);
    }

    @Override
    public int insert(T record) {
        // TODO Auto-generated method stub
        return baseMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateById(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        // TODO Auto-generated method stub
        return baseMapper.updateById(record);
    }
}
