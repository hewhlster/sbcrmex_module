package org.fjh.service;

import org.fjh.util.PageEntity;
import org.fjh.util.higtchart.HighCharts;

import java.util.Date;
import java.util.List;

public interface IReportService extends IBaseService<Object> {
    public PageEntity<Object> customerComposePager(PageEntity<Object> pageEntity);

    //客户组成数据
    public List<Object> customerComposeData();

    /**
     * <p>Description: 获得指定时间内的新增、丢失的客户<／p>
     *
     * @author 樊建华
     * @date 2019年8月4日
     */
    public List<Object> reportCustomerNewLosed(Date bdate, Date edate);

    /**
     * <p>Description: 获得指定时间内的新增、丢失的服务构成<／p>
     *
     * @author 樊建华
     * @date 2019年8月6日
     */
    public HighCharts reportServiceCompose(Date bdate, Date edate);

    /**
     * <p>Description:获得指定时间内服务满意度 <／p>
     *
     * @author 樊建华
     * @date 2019年8月7日
     */
    public HighCharts reportServiceSatisfy(Date bdate, Date edate);

    /**
     *
     */

    public HighCharts reportCompletionDegree(Date bdate, Date edate);


}
