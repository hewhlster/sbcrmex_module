package org.fjh.action;

import org.fjh.entity.Service;
import org.fjh.service.IServiceService;
import org.fjh.util.PageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: ServiceAction.java<／p>
 * <p>
 * Description: 服务模块控制器<／p>
 * <p>
 * Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年7月29日
 */
@Controller()
@RequestMapping("/service")
public class ServiceAction extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(SaleAction.class);

    @Autowired
    private IServiceService serviceService;

    // 返回服务列表视图
    @GetMapping("/listview")
    public String list_view() {
        return "service/list";
    }

    // 返回处理服务列表视图
    @GetMapping("/detailview")
    public String detail_view() {
        return "service/detail";
    }

    // 返回分配服务列表视图
    @GetMapping("/distributionview")
    public String distribution_view() {
        return "service/distribution";
    }

    // 返回分配服务列表视图
    @GetMapping("/feedbackview")
    public String feedback_view() {
        return "service/feedback";
    }

    // 返回分配服务归档列表视图
    @GetMapping("/fileview")
    public String file_view() {
        return "service/file";
    }


    // 返回服务列表分页数据
    @PostMapping("/pager")
    public @ResponseBody
    Map ajaxListPager(@RequestBody Object param) {
        // 绑定查询参数
        PageEntity<Service> pageEx = super.bindPagerParams(param);

        serviceService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", pageEx.getTotal());
        map.put("rows", pageEx.getRows());
        return map;
    }


    // 增加服务
    @GetMapping("/add")
    public @ResponseBody
    Map ajaxAddService(Service param) {
        Map map = new HashMap<>();

        try {
            param.setStatus("0");//新建（待分配）
            serviceService.insertSelective(param);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
            // TODO: handle exception
        }

        return map;
    }

    //服务状态 0:新建(待分配) 1：以分配(待处理) 2:以处理(待反馈) 3:处理完成（待归档） 4:以归档
    // 服务分配
    @GetMapping("/distribution")
    public @ResponseBody
    Map ajaxDistributionService(Service param) {
        Map map = new HashMap<>();

        try {
            param.setFdcreatetime(new Date());
            param.setStatus("1");//更新状态为以分配（待处理）
            serviceService.updateByPrimaryKeySelective(param);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
        }

        return map;
    }

    // 处理服务
    @GetMapping("/detail")
    public @ResponseBody
    Map ajaxDetailService(Service param) {
        Map map = new HashMap<>();

        try {
            param.setStatus("2");//更新状态为处理完成(待反馈)
            serviceService.updateByPrimaryKeySelective(param);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
            // TODO: handle exception
        }

        return map;
    }


    // 服务反馈
    @GetMapping("/feedback")
    public @ResponseBody
    Map ajaxFeedbackService(Service param) {
        Map map = new HashMap<>();

        try {
            param.setStatus("3");//更新状态为反馈完毕（待归档）
            serviceService.updateByPrimaryKeySelective(param);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
        }

        return map;
    }

    // 服务归档
    @GetMapping("/file")
    public @ResponseBody
    Map ajaxFileService(Service param) {
        Map map = new HashMap<>();

        try {
            param.setStatus("4");//更新状态为以归档
            serviceService.updateByPrimaryKeySelective(param);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
        }

        return map;
    }


    // 批量服务归档
    @GetMapping("/batchfiles")
    public @ResponseBody
    Map ajaxFileService(String[] sids) {
        Map map = new HashMap<>();

        try {
            serviceService.updateBatchFiles(sids);
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
        }

        return map;
    }

}
