package org.fjh.service;

import org.fjh.entity.CustomerCommunication;
import org.fjh.util.PageEntity;

public interface ICustomerCommunicationService  extends  IBaseService<CustomerCommunication>{
    /**
     * <p>Description:客户交往历史分页 <／p>
     *
     * @author 樊建华
     * @date 2019年1月30日
     */
/*
    public PageEntity<CustomerCommunication> pager(PageEntity pageEntity);
*/

    public Integer addCommunication(CustomerCommunication cc);

}
