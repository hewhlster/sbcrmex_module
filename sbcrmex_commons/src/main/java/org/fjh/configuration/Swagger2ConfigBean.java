package org.fjh.configuration;


import com.deepoove.swagger.dubbo.annotations.EnableDubboSwagger;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * SWAGGER2 文档接口配置
 * 樊建华
 * 2019/01/01
 */
//@Configuration
//@EnableDubboSwagger
//@DubboComponentScan(basePackages = {"org.fjh.service.impl"})
public class Swagger2ConfigBean {

/*    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.fjh.action"))
                .paths(PathSelectors.any())
                .build().apiInfo(jackApiInfo());
    }

    private ApiInfo jackApiInfo(){
        return new ApiInfoBuilder()
                .title("SB_CRM接口文档")
                .description("java教学项目")
                .version("0.0.1")
                .contact(new Contact("联系信息", "######", "hewlh@163.com"))
                .license("樊建华")
                .build();
    }*/
}
