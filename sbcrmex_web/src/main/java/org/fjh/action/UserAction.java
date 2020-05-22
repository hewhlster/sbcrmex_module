package org.fjh.action;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.fjh.authentication.JackUserDetails;
import org.fjh.entity.User;
import org.fjh.service.IResourceService;
import org.fjh.service.IRoleService;
import org.fjh.service.IUserService;
import org.fjh.util.ResponseResult;
import org.fjh.util.PageEntity;
import org.fjh.util.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.security.core.context.SecurityContextHolder.*;

@Api(description = "用户控制器")
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction {
    @Reference
    private IUserService userService;
    @Reference
    private IResourceService resourceService;
    @Reference
    private IRoleService roleService;

    private static Logger logger = LoggerFactory.getLogger(UserAction.class);

    /**
     * 用途：系统用户视图 作者：樊建华 日期：2019年1月16日-下午9:17:00
     */
    @RequestMapping("/user_view")
    public String userView() {
        return "user/user_view";
    }

    @RequestMapping("/login_view")
    public String loginView() {
        return "login";
    }

    /**
     * 用途： 作者：樊建华 日期：2019年1月21日-下午5:21:17
     */
    @ApiOperation("用户中心视图")
    @RequestMapping("/user_center_view")
    public String userCenterView(HttpSession session) {
        return "/user_center_view";
    }

    /**
     *
     * @param usersCode
     * @param usersPassword
     * @param session
     * @return

    @GetMapping("/login")
    public String login(String usersCode,
                        String usersPassword,
                        HttpSession session) {
        String url = "";
        String msg = "";
        User loginUser = userService.find(usersCode, usersPassword);
        if (null != loginUser && loginUser.getState().equals("0")) {
            // 登陆成功
            // 保存用户信息
            session.setAttribute("logineduser", loginUser);

            User user = (User) session.getAttribute("logineduser");
            // 从session中取得当前登录的用户
            Map<Resource, List<Resource>> map = resourceService.getMenuByRid(user.getRid());
            session.setAttribute("menu", map);
            url = "main";
        } else if (null != loginUser && !loginUser.getState().equals("0")) {
            msg = "用户以禁用，请联系管理员。";
            url = "redirect:/login.html";
        } else {
            msg = "用户名或密码不对。";
            url = "redirect:/login.html";
        }
        logger.info("---------login msg---------\t" + loginUser);
        session.setAttribute("msg", msg);
        return url;
    }

     */
    /**
     * 用途：AJAX登陆
     * 作者：樊建华
     * 日期：2019年1月24日-上午9:50:26

    @GetMapping("/ajax_login")
    public @ResponseBody
    Map ajaxLogin(@ApiParam("用户编号") String usersCode,
                  @ApiParam("用户密码") String usersPassword
    ) {
        String url = "";
        String msg = "";
        User loginUser = userService.find(usersCode, usersPassword);
        if (null != loginUser && loginUser.getState().equals("0")) {
            // 登陆成功
            // 保存用户信息
            getSession().setAttribute("logineduser", loginUser);
            User user = (User) getSession().getAttribute("logineduser");
            // 从session中取得当前登录的用户
            Map<Resource, List<Resource>> map = resourceService.getMenuByRid(user.getRid());
            getSession().setAttribute("menu", map);
            msg = "ok";
            url = getBasePath(getRequest()) + "user/user_main_view";
        } else if (null != loginUser && !loginUser.getState().equals("0")) {
            msg = "用户以禁用，请联系管理员。";
            url = getBasePath(getRequest()) + "login.html";
        } else {
            msg = "用户名或密码不对。";
            url = getBasePath(getRequest()) + "login.html";
        }
        @SuppressWarnings("rawtypes")
        Map json = new HashMap<>();
        json.put("msg", msg);
        json.put("url", url);

        logger.info(">>>>>>>>>>>>>>---------ajaxlogin msg---------<<<<<<<<<<<<<<\t" + loginUser);
        return json;
    }
     */

    /**
     * 用途： 作者：樊建华 日期：2019年1月20日-下午2:07:37
     */
    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.invalidate();// 让session失效
        return "redirect:/login.html";

    }

    @GetMapping("/user_update")
    public @ResponseBody
    Map modifyAccount(User user) {
        int ret = userService.updateUser(user);
        Map map = new HashMap();
        map.put("msg", "ok");
        return map;
    }

    @ApiOperation("增加用户")
    @PostMapping("/user_add")
    public @ResponseBody
    ResponseResult addAccount(@Valid User user) {
        int ret = userService.add(user);
        return ResponseResult.ok(ret);
    }

    @GetMapping("/regist")
    public void regist(String uname) {
        logger.info(uname);
        User ret = userService.getUserByUname(uname);
        logger.info(ret.toString());
    }

    @GetMapping("/user_delete")
    public @ResponseBody
    Map deleteAccount(String id) {
        userService.deleteUser(id);
        Map map = new HashMap();
        map.put("msg", "ok");
        return map;
    }

    /**
     * 用途： 作者：樊建华 日期：2019年1月17日-上午10:16:14
     */
    @PostMapping("/user_pager")
    public @ResponseBody
    ResponseResult pager(@RequestBody Object param) {

        // 绑定查询参数
        PageEntity<User> pageEx = super.bindPagerParams(param);

        pageEx = userService.pagerEx(pageEx);
        Map map = new HashMap<>();

        map.put("total", pageEx.getTotal());
        map.put("rows", pageEx.getRows());

        return ResponseResult.ok(map);

    }

    // 测试
    @RequestMapping("/system_main_view")
    public String mainPage(HttpSession session) {
        JackUserDetails jackUserDetails = (JackUserDetails) getContext().getAuthentication() .getPrincipal();

        String id = jackUserDetails.getId();

        User loginedUser=userService.getUserById(id);
        loginedUser.setRoles(roleService.getRolesByUid(id));

        session.setAttribute("logineduser",loginedUser);

        return "main";
    }

    @GetMapping("/search")
    public @ResponseBody
    List<User> find(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                    @RequestParam(value = "listCount", defaultValue = "10") int listCount,
                    @RequestParam(value = "usercode") String usercode, @RequestParam(value = "rid") String rid) {
        List<User> ret = userService.findByUserCodeOrRid(usercode, rid);
        return ret;
    }

    @GetMapping("/modifypass")
    public @ResponseBody
    Map modifyPass(String usercode, String oldpass, String newpass) {
        Map map = new HashMap();
        int i = userService.modifyPassword(usercode, oldpass, newpass);
        return map;

    }

    @ApiOperation("取得所有用户")
    @GetMapping("/user_all")
    public @ResponseBody
    List<User> allUser() {
        return userService.getAll();
    }

    @GetMapping("/userlistrole")
    public @ResponseBody
    List<User> getUserByRole(String role) {
        return userService.findByRoleCode("3344");
    }

    /**
     *
     * @param session
     * @return

    //@GetMapping("/user_menu")
    public @ResponseBody
    List<TreeNode> getMenuByRid_not_used(HttpSession session) {
        JackUserDetails jackUserDetails = (JackUserDetails) getContext().getAuthentication() .getPrincipal();
        String id = jackUserDetails.getId();

        User loginedUser=userService.getUserById(id);
        String rid = loginedUser.getRid();
        List<TreeNode> ret = resourceService.getMenuByRidEx(rid);
        return ret;
    }
     */

    @GetMapping("/user_menu")
    public @ResponseBody
    ResponseResult getMenuByRid(HttpSession session) {
        JackUserDetails jackUserDetails = (JackUserDetails) getContext().getAuthentication() .getPrincipal();
        String id = jackUserDetails.getId();

        List<TreeNode> ret = resourceService.getMenuByUidEx(id);

        return ResponseResult.ok(ret);
    }

    @GetMapping("/user_detail")
    public @ResponseBody
    User getUserById(String id) {
        return userService.getUserById(id);
    }
}