package org.fjh.action;

import org.fjh.util.PageEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: OrderAction.java<／p>
 * <p>Description: <／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年8月25日
 */
@Controller
@RequestMapping("/order")
public class OrdersAction extends BaseAction {
/*
    //@Reference //引用远程服务(与springmvc结合使用时，dubbo的@Reference会效)
    private IOrdersService ordersService;

    //手动注入
	*//*@Autowired
	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}*//*

    ///////////////////////////////////////////////////////
    //// 历史订单
    @PostMapping("/customer_history_orders_pager")
    public @ResponseBody
    Map historyOrdersPager(@RequestBody Object param) {

        PageEntity pageEx = super.bindPagerParams(param);
        PageEntity ret = ordersService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }


    ///////////////////////////////////////////////////////
    //// 订单商品明细
    @PostMapping("/order_items_pager")
    public @ResponseBody
    Map getOrderItemsPager(@RequestBody Object param) {

        PageEntity pageEx = super.bindPagerParams(param);
        PageEntity ret = ordersService.getOrderItemsPager(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    @GetMapping("/order_view")
    public String orderView() {
        return "basic/order/order_view";
    }*/
}
