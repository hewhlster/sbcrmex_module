package org.fjh.inptercetor;

import org.fjh.entity.OptLog;
import org.fjh.entity.User;
import org.fjh.service.IOptlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * <p>
 * Title: LogIntercept.java<／p>
 * <p>
 * Description: 日志拦截器<／p>
 * <p>
 * Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年1月27日
 */
public class LogIntercept extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(LogIntercept.class);
    @Autowired
    private IOptlogService logservice;

    private OptLog log;

    // 请求方法之后 保存日志
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex == null)
            log.setRet("ok");
        else
            log.setRet("error->" + ex.getLocalizedMessage());
        logservice.insertSelective(log);
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return super.preHandle(request, response, handler);
    }

    // 执行之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        Object user = request.getSession().getAttribute("logineduser");
        String userName = "";
        if (null != user)
            userName = ((User) user).getName();
        log = new OptLog();
        log.setUrl(request.getRequestURL().toString());

        /**
         * ajax方式的请求取不到数据
         * 原因在action中@RequestBody以流的方式读过一次，而以流的方式只能读取一次
         */
        if (isAjaxRequest(request)) {
            StringBuilder sb = new StringBuilder();
            InputStream in = request.getInputStream();
            byte buffer[] = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                sb.append(new String(buffer), 0, len);
            }
            logger.debug("ajax--->" + sb.toString());
        } else {
            if (request.getQueryString() != null) {
                // 根据提交方法类型，取得请求数据
                if (request.getMethod().equalsIgnoreCase("get")) {
                    log.setDatas(new String(request.getQueryString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                } else if (request.getMethod().equalsIgnoreCase("post")) {
                    log.setDatas(getRequestPostStr(request));
                }
            }
        }
        log.setDate(new Date());
        log.setUser(userName);
        log.setIp(request.getRemoteAddr());
        super.postHandle(request, response, handler, modelAndView);
    }

    /***
     * 获取 request 中 json 字符串的内容
     *
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public String getRequestJsonString(HttpServletRequest request) throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).replaceAll("%22", "\"");
            // POST
        } else {
            return getRequestPostStr(request);
        }
    }

    /**
     * 描述:获取 post 请求的 byte[] 数组
     *
     * <pre>
     *
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(buffer, i, contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     *
     * <pre>
     *
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public String getRequestPostStr(HttpServletRequest request) throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    /**
     * <p>
     * Description:判断是否是AJAX请要求 <／p>
     *
     * @author 樊建华
     * @date 2019年8月30日
     */
    public boolean isAjaxRequest(HttpServletRequest req) {
        String with = req.getHeader("X-requested-with");
        return with != null && with.equalsIgnoreCase("XMLHttpRequest");
    }
}
