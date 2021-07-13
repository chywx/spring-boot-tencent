package cn.chendahai;

import cn.chendahai.dingding.service.DingdingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("cn.chendahai.dao")
public class SpringBootTencentApplication {

    public static void main(String[] args) {
        System.out.println("main:" + Thread.currentThread().getName());
        SpringApplication.run(SpringBootTencentApplication.class, args);
    }

    @Bean
    public DingdingService dingdingService() {
        return new DingdingService();
    }


}
