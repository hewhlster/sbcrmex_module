package org.fjh.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.fjh.interceptor.EmptyFieldInterceptor;
import org.fjh.interceptor.IdCUDateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置mybatis的自定义拦截器
 * 樊建华
 * 2020/5/13
 */
@Configuration
public class MybatisConfiguration {

    @Bean
    public String addInterceptor(SqlSessionFactory sqlSessionFactory){
        //取得sqlSessionFactory的配置，加入自定义拦截器
        sqlSessionFactory.getConfiguration().addInterceptor(new IdCUDateInterceptor());
        sqlSessionFactory.getConfiguration().addInterceptor(new EmptyFieldInterceptor());
        return "interceptor";
    }
}
