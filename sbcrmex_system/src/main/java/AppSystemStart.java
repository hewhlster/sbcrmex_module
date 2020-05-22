import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname AppSystemStart
 * @Description TODO
 * @Date 2020/5/21 9:15
 * @Created by Jack
 */
@SpringBootApplication(scanBasePackages = {"org.fjh"})
@MapperScan(basePackages = {"org.fjh.dao"})
@EnableDubbo
public class AppSystemStart {
    public static void main(String args[]){
        SpringApplication.run(AppSystemStart.class,args);
    }
}
