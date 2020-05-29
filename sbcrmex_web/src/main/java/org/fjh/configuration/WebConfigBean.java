package org.fjh.configuration;

import org.fjh.inptercetor.IsLoginedIntercept;
import org.fjh.inptercetor.LogIntercept;
import org.fjh.inptercetor.RoleIntercept;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: WebConfigBean.java<／p>
 * <p>Description:拦截器和站点首页设定 <／p>
 * <p>Copyright: Copyright (c) 2019<／p>
 *
 * @author 樊建华
 * @date 2019年2月26日
 */
@Configuration
@SuppressWarnings("deprecation")
public class WebConfigBean implements WebMvcConfigurer {
    //##################springmvc interceptor######################
/*    @Bean
    public IsLoginedIntercept isLoginedIntercept() {
        return new IsLoginedIntercept();
    }*/
/*
    @Bean
    public LogIntercept logIntercept() {
        return new LogIntercept();
    }

    @Bean
    public RoleIntercept roleIntercept() {
        return new RoleIntercept();
    }*/

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

       // IsLoginedIntercept isloginedIntercept = isLoginedIntercept();
       // LogIntercept logIntercept = logIntercept();
       // RoleIntercept roleIntercept = roleIntercept();

        List<String> excludepatterns = new ArrayList<String>();
        //excludepatterns.add("/static/**"); 此法没有效果
        //排除拦截静态资源
        excludepatterns.add("/plusins/**");
        excludepatterns.add("/css/**");
        excludepatterns.add("/img/**");
        excludepatterns.add("/js/**");
        /*
		excludepatterns.add("/plusins/bootstrap-notify/**");
		excludepatterns.add("/plusins/bootstrap3-editable/**");
		excludepatterns.add("/plusins/bootstraptable/**");
		excludepatterns.add("/plusins/bootstraptreeview/**");
		excludepatterns.add("/plusins/bootstrapvalidator/**");

		excludepatterns.add("/plusins/lay-ui/**");
		excludepatterns.add("/plusins/plusins/**");
		excludepatterns.add("/plusins/popper/**");
		excludepatterns.add("/plusins/zTree_v3/**");
		*/
        ////////////////////////////////////


        //////////////特殊URL
        excludepatterns.add("/");
        excludepatterns.add("/error");
        excludepatterns.add("/auth/login");
        excludepatterns.add("/auth/logout");
        excludepatterns.add("/user/ajax_login");
        //excludepatterns.add("/user/user_main_view");

        //以下内容以交由 SpringSecurity处理，日志经交由LogAspect处理
        //注册拦截器
        //registry.addInterceptor(isloginedIntercept).excludePathPatterns(excludepatterns).addPathPatterns("/**");
        //registry.addInterceptor(logIntercept).excludePathPatterns(excludepatterns).addPathPatterns("/**");
        // test delete
        //registry.addInterceptor(roleIntercept).addPathPatterns("/**").excludePathPatterns(excludepatterns);

    }
    //##################springmvc interceptor#######################


    //##################指定首页######################################
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/").setViewName("login");
        //registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    /*
         以下代码可在application.properties中用
         spring.resources.static-locations=classpath:/static/
        spring.mvc.static-path-pattern=/static/**
        spring.resources.add-mappings=true
    */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

    }

    /**
     * 增加hibernate校验器
     */
    @Bean
    public Validator ValidatorConfiguration() {
            ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                    .configure()
                    .addProperty( "hibernate.validator.fail_fast", "true" )
                    .buildValidatorFactory();
            Validator validator = validatorFactory.getValidator();

            return validator;
    }

}
