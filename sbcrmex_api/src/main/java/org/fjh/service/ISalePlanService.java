package org.fjh.service;

import org.fjh.entity.SalePlan;

import java.util.Date;

/**
 * SalService
 * 版本信息：
 * 日期：2017年12月19日-下午2:21:41
 * 版权:樊建华
 */

public interface ISalePlanService extends IBaseService<SalePlan> {
    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月9日-下午10:14:47
     * status:0 还没执行 1：执行完成
     */
    public Integer updatePlanStatusById(String id, Integer status, String result);

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月9日-下午10:14:47
     * status:0:没指派1：已指派2：关闭3：开发成功
     */
    public Integer updateChanceResultById(String cid, Integer status);


    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月9日-下午10:14:47
     * status:0:没指派1：已指派2：关闭3：开发成功
     */
    public Integer updateChanceResultById(String id, String uid, Date date, String status);

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月11日-下午1:16:26
     */
    public Integer updateChanceStatusById(String id, String status, Date date);
}
