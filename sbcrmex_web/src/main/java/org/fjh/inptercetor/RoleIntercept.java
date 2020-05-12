package org.fjh.inptercetor;

import com.alibaba.fastjson.JSONObject;
import org.fjh.entity.Resource;
import org.fjh.entity.User;
import org.fjh.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月22日-下午4:36:17
 * 版权:樊建华
 */

public class RoleIntercept implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(RoleIntercept.class);

    @Autowired
    private IRoleService roleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession seesion = request.getSession();
        User loginedUser = (User) seesion.getAttribute("logineduser");
        logger.info("RoleIntercept-uri===>" + request.getRequestURI());
        if (loginedUser != null) {
            //根据用户角色得到得权限
            List<Resource> resources = roleService.getResourcesByUid(loginedUser.getId());

            //得到请求URL
            String query = request.getRequestURI();

            //将权限与请要求URL比较
            for (Iterator iterator = resources.iterator(); iterator.hasNext(); ) {
                Resource resource = (Resource) iterator.next();

                String action = resource.getUrl();
                if (query.indexOf(action) > 0) {
                    //查询字符串中有action字符串，说明有这个权限
                    return true;
                }
            }
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            String message = "";
            //根据请求方式，返回不同的信息
            //可根据项目，引导到其它页面或其它返回方式
            String x_requested_with = request.getHeader("x-requested-with");
            if (x_requested_with != null) { //ajax的请求
                Map map = new HashMap();
                map.put("msg", "您没有这个权限");
                message = JSONObject.toJSONString(map);//JSONObject.fromObject(map).toString();
            } else { //传统请求
                message = "<script>alert('您没有这个权限');</script>";
            }
            out.print(message);
            out.flush();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
