package org.fjh.inptercetor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 樊建华 显示用拦截器
 */
//public class IsLoginedIntercept extends HandlerInterceptorAdapter 也可

public class IsLoginedIntercept implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(IsLoginedIntercept.class);

    // 该方法将在整个请求结束之后执行
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // logger.info("afterCompletion");
    }

    // 当前请求进行处理之后，也就是Controller方法调用之后执行

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // logger.info("postHandle");
    }

    // 该方法将在请求处理之前进行调用

    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        String uri = arg0.getRequestURI();
        logger.info("IsLoginedIntercept->uri>>>>>>>>>" + uri);

        // if (uri.indexOf("login.do") > 0 ||
        // uri.indexOf("regist.do")>0 ||
        // uri.indexOf("checkcode.do")>0) {
        // return true;
        // } else {
        // Object logineduser = arg0.getSession().getAttribute("logineduser");
        // if (logineduser != null)
        // return true;// 返回true才能将请求分发到下一个资源
        // else {
        // //跳转到登录页
        // arg0.getRequestDispatcher("login.jsp").forward(arg0, arg1);
        // return false;
        // }
        // }
        Object logineduser = arg0.getSession().getAttribute("logineduser");

        if (null == logineduser) {
            String path = arg0.getContextPath();
            String basePath = arg0.getScheme() + "://" + arg0.getServerName() + ":" + arg0.getServerPort() + path + "/";
            String url = basePath + "";
            // 跳转到登录页
            //传统方式
//				arg1.sendRedirect(url);
            //本项目用了iframe，要跳出来
            url = "<script>window.parent.location='" + url + "'</script>";
            arg1.getWriter().write(url);
            arg1.getWriter().flush();
            arg1.getWriter().close();

            return false;
        }
        // 返回true才能将请求分发到下一个资源
        return true;


    }
}
