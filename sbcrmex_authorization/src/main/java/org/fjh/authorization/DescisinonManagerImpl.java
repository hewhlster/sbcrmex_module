package org.fjh.authorization;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * 授权管理器
 */
@Component
public class DescisinonManagerImpl implements
        AccessDecisionManager {
    @Override
    public void decide(Authentication authentication,//以认证的用户
                       Object object,
                       Collection<ConfigAttribute> configAttributes //待授权的角色标签
    ) throws AccessDeniedException, InsufficientAuthenticationException {

        authentication.getAuthorities();

        Iterator<ConfigAttribute> it = configAttributes.iterator();
        while (it.hasNext()) {
            ConfigAttribute configAttribute = it.next();
            String role_tage = configAttribute.getAttribute();//得到资源角色标签
            //取得以认证的用户拥友的角色标签
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                //比较通过，直接返回
                if (grantedAuthority.getAuthority().equalsIgnoreCase(role_tage))
                    return;
            }
        }

        throw new AccessDeniedException("授权失败");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
