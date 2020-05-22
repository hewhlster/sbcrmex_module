package org.fjh.action;

import org.apache.dubbo.config.annotation.Reference;
import org.fjh.entity.CustomerCommunication;
import org.fjh.entity.User;
import org.fjh.service.ICustomerCommunicationService;
import org.fjh.util.PageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerCommunicationAction extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(CustomerCommunicationAction.class);


    @Reference
    private ICustomerCommunicationService customerCommunicationServiceImpl;

    @GetMapping("/customer_history_communication_view")
    public String customer_history_communication_view(String cid, Model model) {
        model.addAttribute("cid", cid);
        return "customer/customer_history_communication_view";
    }

    @PostMapping("/customer_communication_pager")
    @ResponseBody
    public Map pager(@RequestBody Object param) {
        PageEntity<CustomerCommunication> pageEx = super.bindPagerParams(param);
        PageEntity<CustomerCommunication> ret = customerCommunicationServiceImpl.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    @GetMapping("/ajax_customer_communication_add")
    @ResponseBody
    public Map ajax_save(CustomerCommunication cc, HttpSession session) {
        Map map = new HashMap<>();
        cc.setCuid(((User) session.getAttribute("logineduser")).getId());
        Integer ret = customerCommunicationServiceImpl.addCommunication(cc);
        if (ret != null)
            map.put("msg", "ok");
        else
            map.put("msg", "ng");
        return map;
    }
}
