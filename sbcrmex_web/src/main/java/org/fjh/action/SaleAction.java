package org.fjh.action;

import org.fjh.dao.SaleChanceMapper;
import org.fjh.entity.Customer;
import org.fjh.entity.SaleChance;
import org.fjh.entity.SalePlan;
import org.fjh.service.ICustomerService;
import org.fjh.service.ISaleChanceService;
import org.fjh.service.ISalePlanService;
import org.fjh.util.PageEntity;
import org.fjh.util.SpecialDateEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售机会管理控制层 版本信息： 日期：2017年12月19日-下午2:26:51 版权:樊建华
 */
@Controller
@RequestMapping("/sale")
public class SaleAction extends BaseAction {
    private Logger logger = LoggerFactory.getLogger(SaleAction.class);

    @Autowired
    private ISaleChanceService saleChanceService;
    @Autowired
    private ISalePlanService salePlanService;
    @Autowired
    private ICustomerService customerService;


    /**
     * 用途：销售机会视图 作者：樊建华 日期：2017年12月19日-下午4:34:24
     */
    @GetMapping("/sale_chance_view")
    public String saleChanceView() {
        return "salechance/salechance_view";
    }

    /**
     * 用途：销售计划视图 作者：樊建华 日期：2018年1月20日-下午3:26:33
     */
    @GetMapping("/sale_plan_view")
    public String salePlanView() {

        return "saleplan/saleplan_view";
    }

    /**
     * 用途：新增销售计划视图 作者：樊建华 日期：2018年1月21日-上午9:44:02
     */
    @GetMapping("/saleplanaddmv")
    public String salePlanAddMv() {
        return "salesplan/salesPlan-add";
    }

    /**
     * sale_plan_detail_view
     */
    @GetMapping("/sale_plan_detail_view")
    public String salePlanDetailMv(HttpServletRequest request, Model model) {
        model.addAttribute("cid", request.getParameter("cid"));
        return "saleplan/saleplan_detail_view";
    }


    /**
     * 用途：新增或更新销售机会 作者：樊建华 日期：2017年12月19日-下午2:29:13 //type: 0：新建 1：查看 2:编辑 3:指派
     */
    @GetMapping("/sale_chance_saveorupdate")
    public @ResponseBody
    Object saleChanceAdd(Integer type, SaleChance salChance, Map map) {
        if (salChance.getId() != null && salChance.getId().equals(""))
            salChance.setStatus("0");// 没有指派设定状态
        // else
        // salChance.setOptStatus("1");// 指派设定状态
        int ret = 0;
        // 操作code
        // 0：新建 1：查看 2:编辑 3:指派
        if (type == 0) {
            ret = saleChanceService.insertSelective(salChance);
        } else if (type == 1) {
            salChance = saleChanceService.selectByPrimaryKey(salChance.getId());
        } else if (type == 2) {
            ret = saleChanceService.updateByPrimaryKey(salChance);
        } else if (type == 3) {
            ret = saleChanceService.updateChanceStatusById(salChance.getId(), 1 + "", salChance.getUpdatedate());
        }
        map.put("msg", ret);
        return salChance;
    }

    /**
     * <p>Description:保存销售计划项目 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_plan_save")
    public @ResponseBody
    Object salePlanSave(SalePlan salPlan) {
        salPlan.setStatus(0);
        salePlanService.insertSelective(salPlan);

        Map map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }


    /**
     * <p>Description:更新销售计划项目 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_plan_update")
    public @ResponseBody
    Object salePlanUpdate(@RequestBody SalePlan salPlan) {
        // 执行了计划
        salePlanService.updatePlanStatusById(salPlan.getId(), 1, salPlan.getResult());

        Map map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

    /**
     * <p>Description:更新或删除销售计划项目 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_plan_saveordelete")
    public @ResponseBody
    Object salePlanSaveOrDelete(Integer type, SalePlan salPlan) {
        type = 0;
        if (type == 0) {// 保存
            salPlan.setStatus(1);
            salePlanService.insertSelective(salPlan);
        } else if (type == 1) // 删除
            salePlanService.deleteByPrimaryKey(salPlan.getId());
        Map map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }


    /**
     * <p>Description: 执行销售计划<／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_plan_exec")
    public @ResponseBody
    Object salePlanExec(SalePlan salPlan) {
        salPlan.setStatus(1);
        salePlanService.updatePlanStatusById(salPlan.getId(), 1, salPlan.getResult());
        Map map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }

    /**
     * <p>Description:取得销售机会 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_chance_get")
    public @ResponseBody
    Object salchancget(@RequestParam("optno") String OptNo) {
        SaleChance salChance = saleChanceService.selectByPrimaryKey(OptNo);
        return salChance;
    }

    /**
     * <p>Description:获取销售计划项目 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_plan_detail")
    public @ResponseBody
    Object salPlanDetail(@RequestParam("id") String id) {
        //List<SalePlan> ret = salePlanService.selectByPrimaryKey(id);
        List<SalePlan> ret = null;

        return ret;
    }


    /**
     * <p>Description:终结销售机会 <／p>
     *
     * @author 樊建华
     * @date 2019年8月1日
     */
    @GetMapping("/sale_chance_end")
    public @ResponseBody
    Map saleChanceEnd(String optno, String status, Map map) {
        SaleChance salChance = new SaleChance();
        salChance.setId(optno);
        salChance.setStatus(status);// 设定关闭
        try {
            saleChanceService.updateByPrimaryKeySelective(salChance);
            if (status.equals("3")) {
                //开发成功，保存客源信息
                SaleChance sc = saleChanceService.selectByPrimaryKey(optno);
                Customer customer = new Customer();
                customer.setName(sc.getCname());
                customer.setAddr(sc.getCaddr());
                customer.setManager(sc.getLname());
                customer.setStatus("0");
                customer.setTel(sc.getLtel1());
                customerService.insertSelective(customer);
            }
            map.put("msg", "ok");
        } catch (Exception e) {
            map.put("msg", "ng");
            logger.debug(e.toString());
        }
        return map;
    }


    @PostMapping("/sale_plan_pager")
    public @ResponseBody
    Map salePlanPager(@RequestBody Object param) {
        PageEntity<SalePlan> pageEx = super.bindPagerParams(param);

        PageEntity<SalePlan> ret = salePlanService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }


    @PostMapping("/sale_chance_pager")
    public @ResponseBody
    Map saleChancePager(@RequestBody Object param) {
        PageEntity<SaleChance> pageEx = super.bindPagerParams(param);

        PageEntity<SaleChance> ret = saleChanceService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", ret.getTotal());
        map.put("rows", ret.getRows());
        return map;
    }

    // 注册日期转换器
    // @InitBinder
    protected void initBinder(HttpServletRequest request, WebDataBinder binder) {
        binder.registerCustomEditor(java.util.Date.class, new SpecialDateEditor());
    }

}
