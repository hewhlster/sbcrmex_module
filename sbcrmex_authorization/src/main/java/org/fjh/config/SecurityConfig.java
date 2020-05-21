package org.fjh.config;


import org.fjh.authentication.Md5PasswordEncoder;
import org.fjh.authorization.JackAccessDeniedHandler;
import org.fjh.authorization.SercurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * SpringSecurity 安全配置
 * 樊建华
 * 2020/05/11 0:39
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    Md5PasswordEncoder md5PasswordEncoder;//密码编码器

    @Autowired
    JackAccessDeniedHandler jackAccessDeniedHandler;//授权失败处理器

    @Autowired
    SercurityInterceptor sercurityInterceptor;//拦截器

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被SpringSecurity拦截的问题
        web.ignoring().antMatchers("/static/**");//这样我的webapp下static里的静态资源就不会被拦截了，也就不会导致我的网页的css全部失效了……
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                    .loginPage("/user/login_view") //登陆认证页
                    .loginProcessingUrl("/auth/login")//认证
                    .defaultSuccessUrl("/user/system_main_view")//认证成功跳转URL
                    .failureUrl("/user/login_view?error")//  定义当需要用户登录时候，转到的登录页面。
                    .usernameParameter("usersCode")
                    .passwordParameter("usersPassword")
                    .permitAll()
                //.failureHandler(jackAccessDeniedHandler)
                .and()

                .logout()//退出配置
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/user/login_view")
                    .clearAuthentication(true)
                    .permitAll()
                .and()

                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                    .antMatchers("/css/**","/img/**","/js/**","/plusins/**").permitAll()
                    //.antMatchers("/user/login_view").permitAll()
                    .antMatchers("/user/login_view","/login.html").permitAll()
                .anyRequest().authenticated()               // 其它任何请求,登录后可以访问
                .and()
                .csrf().disable();

        //增加自定义过滤器
        http.addFilterBefore(sercurityInterceptor, FilterSecurityInterceptor.class);
    }
}
