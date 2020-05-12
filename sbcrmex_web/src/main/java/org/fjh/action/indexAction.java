package org.fjh.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: indexAction.java<／p>
 * <p>Description: 指定首页<／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年3月18日
 */
@Controller
public class indexAction extends BaseAction {
    @GetMapping("/")
    public String index() {
        return "login";
    }
}
