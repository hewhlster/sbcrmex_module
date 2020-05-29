package org.fjh.action;

import com.alibaba.fastjson.JSONObject;
import org.fjh.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 作用：
 * 版本信息：
 * 日期：2019年1月24日-上午9:54:42
 * 版权:樊建华
 */
@Controller
public class BaseAction {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private String path;
    private String basePath;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;



    @ExceptionHandler
    public String error(HttpServletRequest request, Exception ex){
        request.setAttribute("ex",ex);
        return "error";
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }

    public HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getPath(HttpServletRequest request) {
        return request.getContextPath();
    }

    public String getBasePath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + getPath(request) + "/";
    }


    public PageEntity bindPagerParams(Object param) {
        Map map = new HashMap<>();
        JSONObject json = JSONObject.parseObject(param.toString());
        logger.info(json.toString());
        //取得分页参数
        Integer pageNumber = (Integer) json.get("page");
        Integer pageSize = (Integer) json.get("rows");
        String sortOrder = (String) json.get("sortOrder");
        //查询参数
        Set<String> keySet = json.keySet();
        Map params = new HashMap<>();
        for (String key : keySet) {
            if (!key.equalsIgnoreCase("page") &&
                    !key.equalsIgnoreCase("rows") &&
                    !key.equalsIgnoreCase("sortOrder")
            ) {
                if (json.get(key).toString().length() > 0)
                    //准备查询参数
                    params.put(key, json.get(key));
            }
        }
        PageEntity pageEx = new PageEntity<>();
        pageEx.setPageNumber(pageNumber);
        pageEx.setPageSize(pageSize);
        pageEx.setSortOrder(sortOrder);
        pageEx.setParams(params);

        return pageEx;
    }
}
