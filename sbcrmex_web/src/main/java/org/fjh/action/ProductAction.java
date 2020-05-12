package org.fjh.action;

import org.fjh.util.PageEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductAction extends BaseAction {

    //@Reference
 /*   private IProductService productService;

    @GetMapping("/product_view")
    public String product_view() {
        return "basic/product/product_view";
    }

    @PostMapping("/pager")
    public @ResponseBody
    Map pager(@RequestBody Object param) {
        Map map = new HashMap<>();
        PageEntity pageEx = bindPagerParams(param);
        pageEx = productService.pagerEx(pageEx);
        map.put("total", pageEx.getTotal());
        map.put("rows", pageEx.getRows());
        return map;
    }*/
}
