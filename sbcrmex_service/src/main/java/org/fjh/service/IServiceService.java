package org.fjh.service;


import org.fjh.entity.Service;

/**
 * <p>Title: IServiceService.java<／p>
 * <p>Description:服务接口 <／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年7月29日
 */
public interface IServiceService extends IBaseService<Service> {
    /**
     * <p>Description: 批量服务归档<／p>
     *
     * @author 樊建华
     * @date 2019年7月31日
     */
    public int updateBatchFiles(String[] sids);
}
