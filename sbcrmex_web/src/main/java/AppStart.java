import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

//spring要扫描包的基路径
@SpringBootApplication(scanBasePackages = {"org.fjh"})
// mybatis扫描映射配置文件的基路径
@MapperScan(basePackages = {"org.fjh.dao"})
// servlet扫描包的基路径
//@ServletComponentScan(value = "org.fjh.listener")
// 开启自动配置
public class AppStart {
    //放入非内置Tomcat容器运行
    //extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppStart.class);
    }

    // ###########################################################
    // 程序入口
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }

}
