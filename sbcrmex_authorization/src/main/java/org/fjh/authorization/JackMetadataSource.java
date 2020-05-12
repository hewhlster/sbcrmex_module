package org.fjh.authorization;

import org.fjh.dao.JackDaoAuthenticationUserMapper;
import org.fjh.entity.Resource;
import org.fjh.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 授权时所要采用的数据源
 */
@Component
public class JackMetadataSource implements
        FilterInvocationSecurityMetadataSource {


    @Autowired
    private JackDaoAuthenticationUserMapper jackDaoAuthenticationUserMapper;

    // key 是角色标签， value 是对应角色所拥有的url资源的列表

    private HashMap<String, Collection<ConfigAttribute>> map =null;


    private void  InitResourceDefined(){
        map = new HashMap<>();
        List<Role> roles= jackDaoAuthenticationUserMapper.findRolesAll();
        if( roles!=null&&roles.size()>0){
            Iterator<Role> it=roles.iterator();
            while (it.hasNext()){
                Role role = it.next();
                //根据角色取得所拥友的资源
                List<Resource> resources=jackDaoAuthenticationUserMapper.findResourcesByRid(role.getId());
                ArrayList<ConfigAttribute> securityConfigs = new ArrayList<ConfigAttribute>();
                Iterator<Resource> it1=resources.iterator();
                while (it1.hasNext()){
                    Resource resource = it1.next();
                    if(resource!=null && !StringUtils.isEmpty(resource.getUrl())) {
                        SecurityConfig sercurityConfig = new SecurityConfig(resource.getUrl());
                        securityConfigs.add(sercurityConfig);
                    }
                }
                //加入map
                map.put(role.getTag(),securityConfigs);
            }
        }
    }

    //根据请要求的URL取得是否要在检查的范围中，取在就返回决策器来进行决策，否则就放行
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        Collection<ConfigAttribute> roleConfigAttribute=null;
        //取得请求对象
        HttpServletRequest request = ((FilterInvocation)object).getRequest();

        //初始化角色标签和对应的URL
        if( map==null || map.size()==0)
            InitResourceDefined();

        //取所请求对象所对应的角色标签
        for (  Map.Entry<String, Collection<ConfigAttribute>> entry: map.entrySet() )
        {
            Collection<ConfigAttribute>  configAttributes= entry.getValue();
            for (Iterator<ConfigAttribute> iterator=configAttributes.iterator();iterator.hasNext();){
                ConfigAttribute ca = iterator.next();
                //根据资源URL构造
                AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(ca.getAttribute());
                if( antPathRequestMatcher.matches(request)){
                    String role_tag = entry.getKey();
                    if( roleConfigAttribute==null){
                        roleConfigAttribute = new ArrayList<>();
                    }
                    roleConfigAttribute.add(new ConfigAttribute() {
                        @Override
                        public String getAttribute() {
                            return role_tag;
                        }
                    });
                    //退出当前循环
                    break;
                }
            }

        }
        return  roleConfigAttribute;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<>();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
