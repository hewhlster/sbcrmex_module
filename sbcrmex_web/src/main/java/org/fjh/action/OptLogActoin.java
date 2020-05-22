package org.fjh.action;

import org.apache.dubbo.config.annotation.Reference;
import org.fjh.entity.OptLog;
import org.fjh.service.IOptlogService;
import org.fjh.util.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/optlog")
public class OptLogActoin extends BaseAction {
    @Reference
    private IOptlogService optLogService;

    @GetMapping("/optlog_view")
    public String optlog_view() {
        return "log/log_view";
    }

    @PostMapping(value = "/optlog_pager")
    public @ResponseBody
    Map pager(@RequestBody Object param) {
        PageEntity<OptLog> pageEx = bindPagerParams(param);
        pageEx = optLogService.pagerEx(pageEx);
        Map map = new HashMap<>();
        map.put("total", pageEx.getTotal());
        map.put("rows", pageEx.getRows());
        return map;
    }
}
