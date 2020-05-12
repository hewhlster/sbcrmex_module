package org.fjh.action;

import org.fjh.service.IReportService;
import org.fjh.util.PageEntity;
import org.fjh.util.higtchart.HighCharts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping("/report")
public class ReportAction extends BaseAction {

    @Autowired
    private IReportService reportService;

    /**
     * <p>
     * Description:报表视图action <／p>
     *
     * @author 樊建华
     * @date 2019年3月12日
     */
    // 组成
    @GetMapping("/customer_compose_view")
    public String customerComposeView() {
        return "report/report_customer_compose_view";
    }

    // 贡献
    @GetMapping("/customer_contribution_view")
    public String customerContributionView() {
        return "report/report_customer_Contribution_view";
    }

    // 流失
    @GetMapping("/customer_lose_view")
    public String customerLoseView() {
        return "report/report_customer_Lose_view";
    }

    // 服务
    @GetMapping("/customer_service_view")
    public String customerServiceView() {
        return "/report/report_customer_service_view";
    }

    @PostMapping("/cutomer_compose_pager")
    @ResponseBody
    public Map cutomerComposePager(@RequestBody Object param) {
        // 绑定查询参数
        PageEntity<Object> pageEx = super.bindPagerParams(param);
        reportService.customerComposePager(pageEx);
        Map map = new HashMap<>();

        map.put("total", pageEx.getTotal());
        map.put("rows", pageEx.getRows());
        return map;

    }

    @GetMapping("/cutomer_compose_data")
    @ResponseBody
    public List cutomerComposeData() {
        // 绑定查询参数
        Map map = new HashMap<>();
        return reportService.customerComposeData();

    }

    @GetMapping("/cutomer_add_lose_data")
    @ResponseBody
    public List cutomerAddLostData() {
        // 数据格式
        class DataFormat {
            private String name;
            private List<Integer> data;
            private String stack;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Integer> getData() {
                return data;
            }

            public void setData(List<Integer> data) {
                this.data = data;
            }

            public String getStack() {
                return stack;
            }

            public void setStack(String stack) {
                this.stack = stack;
            }

        }

        // 绑定查询参数
        Map map = new HashMap<>();
        return reportService.customerComposeData();

    }

    // 服务类型比率构成
    @GetMapping("/service_compose_report")
    @ResponseBody
    public HighCharts ServiceComposeReport() {
        return reportService.reportServiceCompose(null, null);
    }

    // 服务完成度
    @GetMapping("/service_completion_degree_report")
    @ResponseBody
    public HighCharts ServiceCompletionDegreeReport() {
        return reportService.reportCompletionDegree(null, null);

    }

    // 服务满意度
    @GetMapping("/service_satisfaction_report")
    @ResponseBody
    public HighCharts ServiceSatisfactionReport() {
        return reportService.reportServiceSatisfy(null, null);
    }

}
