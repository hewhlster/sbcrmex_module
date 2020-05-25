package org.fjh.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
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

    //Mybatis-plus 分页查询拦截器
    @Bean
      public PaginationInterceptor paginationInterceptor() {
                 PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
                 return paginationInterceptor;
       }
}
