package org.fjh.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * SWAGGER2 文档接口配置
 * 樊建华
 * 2019/01/01
 */
//@Configuration
//@EnableSwagger2()
public class Swagger2ConfigBean {

    @Bean
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
                .contact(new Contact("联系信息", "http://www.baidu.com", "hewlh@163.com"))
                .license("樊建华")
                .build();
    }
}
