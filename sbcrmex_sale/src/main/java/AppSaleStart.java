import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname AppStart
 * @Description TODO
 * @Date 2020/5/21 9:15
 * @Created by Jack
 */
@SpringBootApplication(scanBasePackages = {"org.fjh"})
@MapperScan(basePackages = {"org.fjh.dao"})
@EnableDubbo
public class AppSaleStart {
    public static void main(String args[]){
        SpringApplication.run(AppSaleStart.class,args);
    }
}
