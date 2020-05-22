package org.fjh.action;


import org.apache.dubbo.config.annotation.Reference;
import org.fjh.entity.Customer;
import org.fjh.entity.CustomerLostCommunication;
import org.fjh.entity.User;
import org.fjh.service.ICustomerLostCommunicationServcie;
import org.fjh.service.ICustomerService;
import org.fjh.util.PageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 版本信息：
 * 日期：2017年12月19日-上午11:06:57
 * 版权:樊建华
 */

@Controller
@RequestMapping("/customer")
public class CustomerAction extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(Customer.class);
    @Reference
    private ICustomerService customerService;

    @Reference
    private ICustomerLostCommunicationServcie customerLostCommunicationServcie;

    @GetMapping("/customer_view")
    public String customerSelectMV() {
        return "customer/customer_view";
    }


    @GetMapping("/customer_lost_view")
    public String customerLostMV() {
        return "customer/lost/customer_lost_view";
    }

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月13日-下午2:08:51
     */
    @GetMapping("/customer_detail_view")
    public String customerDetail(String id, Model model) {
        model.addAttribute("id", id);//将客户ID传到页图中
        return "customer/customer_detail_view";
    }

    /**
     * 增加客户
     * 樊建华
     * 2017年12月19日-上午11:38:36
     */
    @GetMapping("/customer_add")
    public @ResponseBody
    Map customerAdd(Customer customer) {
        logger.info(customer.toString());
        Serializable ret = customerService.insertSelective(customer);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");

        return map;
    }

    @GetMapping("/customereditmv")
    public ModelAndView customeredit(@RequestParam(value = "cstno") String cstNo, ModelAndView mv) {
        Customer customer = customerService.selectByPrimaryKey(cstNo);
        mv.addObject("customer", customer);
        mv.setViewName("/clientManageHtml/clientManage-edit");
        return mv;
    }

    /**
     * 用途：
     * 作者：樊建华
     * 日期：2019年1月14日-上午10:38:47
     */
    @GetMapping("/customer_detail")
    public @ResponseBody
    Customer getCustomerById(String id) {
        Customer customer = customerService.selectByPrimaryKey(id);
        return customer;
    }

    @GetMapping("/customer_edit")
    public @ResponseBody
    Map customerUpdate(Customer customer) {
        Serializable ret = customerService.updateByPrimaryKey(customer);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");
        return map;
    }


    @PostMapping("/customer_pager")
    public @ResponseBody
    Map pager(@RequestBody Object param) {
        PageEntity<Customer> pageEx = super.bindPagerParams(param);
        PageEntity<Customer> ret = customerService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }


    @GetMapping("/customer_history_order_view")
    public String customer_history_order_view() {
        return "customer/customer_history_order_view";
    }

    ////////////////////////////////////////////////////////
    ///流失客户管理

    /**
     * <p>Description: 流失客户管理列表<／p>
     *
     * @author 樊建华
     * @date 2019年8月23日
     */
    @GetMapping("/customer_lost_pager")
    public @ResponseBody
    Map LostCustomerPager(@RequestBody Object param) {
        PageEntity<Customer> pageEx = super.bindPagerParams(param);
        PageEntity<Customer> ret = customerService.lostPager(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    /**
     * <p>Description: 暂缓流失客户沟通信息列表<／p>
     *
     * @author 樊建华
     * @date 2019年8月23日
     */
    @GetMapping("/customer_pasue_lost_communication_pager")
    public @ResponseBody
    Map PasueLostCustomerCommunicationPager(@RequestBody Object param) {
        PageEntity<CustomerLostCommunication> pageEx = super.bindPagerParams(param);
        PageEntity<CustomerLostCommunication> ret = customerLostCommunicationServcie.pagerEx(pageEx);
        Map map = new HashMap<>();
        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    /**
     * <p>Description:增加沟通记录 <／p>
     *
     * @author 樊建华
     * @date 2019年8月23日
     */
    @GetMapping("/add_record_lost_communication")
    public @ResponseBody
    Map addLostCommunicationRecord(CustomerLostCommunication record, HttpSession session) {
        Map map = new HashMap();
        try {
            User logineduser = (User) session.getAttribute("logineduser");
            record.setUid(logineduser.getId());//指定操纵者
            Serializable ret = customerLostCommunicationServcie.insertSelective(record);
            if (ret != null)
                map.put("msg", "ok");
            else
                map.put("msg", "ng");
            return map;
        } catch (Exception e) {
            logger.error("customerAction-->addLostCommunicationRecord!" + e.getLocalizedMessage());
            map.put("msg", "ng");
        }

        return map;
    }

    /**
     * <p>Description:确认客户流失 <／p>
     *
     * @author 樊建华
     * @date 2019年8月24日
     */
    @GetMapping("/confirm_lost")
    public @ResponseBody
    Map confirmLost(String cid) {
        Integer ret = customerService.confirmLostCustomer(cid);
        Map map = new HashMap();
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");
        return map;
    }
}
