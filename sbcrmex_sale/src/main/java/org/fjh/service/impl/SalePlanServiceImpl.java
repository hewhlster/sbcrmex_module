package org.fjh.service.impl;

import org.fjh.dao.CustomerMapper;
import org.fjh.dao.SalePlanMapper;
import org.fjh.entity.SalePlan;
import org.fjh.service.ICustomerLinkmanService;
import org.fjh.service.ISalePlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SalePlanServiceImpl extends BaseServiceImpl<SalePlan> implements ISalePlanService {
    private Logger logger = LoggerFactory.getLogger(SalePlanServiceImpl.class);


    private SalePlanMapper salePlanMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ICustomerLinkmanService customerLinkmanService;

    @Autowired
    public void setSalePlanMapper(SalePlanMapper salePlanMapper) {
        super.setBaseMapper(salePlanMapper);
        this.salePlanMapper = salePlanMapper;
    }

    /***
     * 销售计划分页
     */



    @Override
    public Integer updatePlanStatusById(String id, Integer status, String result) {
        // TODO Auto-generated method stub
        return null;//salPlanMapper.updateStatusByPrimaryKey(id, status, result);
    }


    @Override
    public Integer updateChanceResultById(String id, Integer status) {
        // TODO Auto-generated method stub
        //更新计划项目状态

        //更新销售机会状态
        return null;
    }


    @Override
    public Integer updateChanceResultById(String id, String uid, Date date, String status) {
        //更新计划项目状态(所有状态为执行完成)
 /*       List<SalPlan> list = salPlanMapper.getByChance(id);
        for (SalPlan t : list) {
            String pid = t.getPlanid();
            if (t.getPlanstatus() == 0)//更新还没有执行过的计划
                salPlanMapper.updateStatusByPrimaryKey(pid, 1, "结束计划时加入");
        }

        //更新销售机会状态
        SalChance record = new SalChance();
        record.setOptNo(id);
        record.setOptDueDate(date);
        record.setOptStatus(status);

        salChanceMapper.updateByPrimaryKeySelective(record);


        record = salChanceMapper.selectByPrimaryKey(id);//得到销售机会的所有数据
        //开发成功，将销售机会中的客户加入系统
        if (status.equals("3")) {
            Customer c = new Customer();
            c.setCstName(record.getOptLkmName());//
            c.setCstTel(record.getOptLkmTel());
            customerMapper.insertSelective(c);//部分保存
            //保存联系人信息
            CstLinkMan linkman = new CstLinkMan();
            linkman.setLkmCustNo(c.getCstNo());
            linkman.setLkmTel(c.getCstTel());
            customerLinkmanService.add(linkman);
            logger.info(c.toString());
        }*/
        return null;
    }


    @Override
    public Integer updateChanceStatusById(String id, String status, Date date) {
/*        SalChance salChance = new SalChance();
        salChance.setOptNo(id);
        salChance.setOptDueDate(date);
        salChance.setOptStatus(status);

        return salChanceMapper.updateByPrimaryKeySelective(salChance);*/
return null;
    }
}
