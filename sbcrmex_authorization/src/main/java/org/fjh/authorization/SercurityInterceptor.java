package org.fjh.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.*;
import java.io.IOException;

/**
 * 授权拦截器
 */
@Component
public class SercurityInterceptor extends
        AbstractSecurityInterceptor
        implements Filter {
    //授权管理器
    @Autowired
    @Qualifier("descisinonManagerImpl")
    AccessDecisionManager accessDecisionManager;
    //授权资源来源组件
    @Autowired
    JackMetadataSource jackMetadataSource;

    //指定授权决策管理器
    @PostConstruct
    public void initDesisionManager() {
        super.setAccessDecisionManager(accessDecisionManager);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return jackMetadataSource;
    }


    //拦截逻辑
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        //filterInvocation里面有一个被拦截的url
        //里面调用jackMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限
        //再调用descisinonManagerImpl的decide方法来校验用户的权限是否足够


        FilterInvocation filterInvocation =
                new FilterInvocation(servletRequest, servletResponse, filterChain);

        InterceptorStatusToken token = super.beforeInvocation(filterInvocation);
        try {
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getHttpResponse());
        } finally {
            super.afterInvocation(token, null);
        }

       // filterChain.doFilter(servletRequest, servletResponse);
    }


}

