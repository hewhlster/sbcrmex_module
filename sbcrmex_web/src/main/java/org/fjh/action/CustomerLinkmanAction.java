package org.fjh.action;

import org.apache.dubbo.config.annotation.Reference;
import org.fjh.entity.CustomerLinkman;
import org.fjh.service.ICustomerLinkmanService;
import org.fjh.util.PageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月13日-下午2:42:41
 * 版权:樊建华
 */

@Controller()
@RequestMapping("/customerlinkman")
public class CustomerLinkmanAction extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(CustomerLinkmanAction.class);

    @Reference
    private ICustomerLinkmanService customerLinkmanService;

    @PostMapping("/linkman_pager")
    public @ResponseBody
    Map pager(@RequestBody Object param) {
        Map map = new HashMap<>();
        PageEntity<CustomerLinkman> pageEx = super.bindPagerParams(param);

        PageEntity<CustomerLinkman> ret = customerLinkmanService.pagerEx(pageEx);
        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月13日-下午8:11:56
     * clm：联系人信息
     */
    @GetMapping("/linkman_add")
    public @ResponseBody
    Map add(CustomerLinkman clm) {
        customerLinkmanService.insertSelective(clm);

        Map map = new HashMap();
        map.put("msg", "ok");

        return map;
    }
}
