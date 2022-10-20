package cn.chendahai;

import cn.chendahai.dingding.service.DingdingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

@SpringBootApplication
@MapperScan("cn.chendahai.dao")
public class SpringBootTencentApplication {

    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        long startTime = System.currentTimeMillis();
        sw.start("chy");
        System.out.println("main:" + Thread.currentThread().getName());
        SpringApplication.run(SpringBootTencentApplication.class, args);
        sw.stop();
        System.out.println("程序运行时间：" + sw.getLastTaskTimeMillis());
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime));    //输出程序运行时间
    }

    @Bean
    public DingdingService dingdingService() {
        return new DingdingService();
    }


}
