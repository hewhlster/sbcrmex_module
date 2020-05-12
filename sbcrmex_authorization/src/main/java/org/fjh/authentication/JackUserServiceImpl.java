package org.fjh.authentication;

import org.fjh.dao.JackDaoAuthenticationUserMapper;
import org.fjh.entity.Role;
import org.fjh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class JackUserServiceImpl implements UserDetailsService {

    @Autowired
    JackDaoAuthenticationUserMapper jackDaoAuthenticationUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User ret= jackDaoAuthenticationUserMapper.findUserByEmailOrMoblie(username,username);

        if( ret==null)
            throw new UsernameNotFoundException("找不到此用户");
        //构建用户角色信息
       /* Collection< GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));*/

       List<Role> roles=jackDaoAuthenticationUserMapper.findRolesByUid(ret.getId());
        Collection<GrantedAuthority> authorities= new ArrayList<>();
       for (Role role:roles){
           authorities.add(new SimpleGrantedAuthority(role.getTag()));
       }
        //创建一个UserDetails对象
        JackUserDetails jackUserDetails = new JackUserDetails(ret.getId(),ret.getName(),ret.getPassword(),authorities);
        return jackUserDetails;
    }
}
