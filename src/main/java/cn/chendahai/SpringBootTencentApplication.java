package cn.chendahai;

import cn.chendahai.dingding.service.DingdingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootTencentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTencentApplication.class, args);
    }

    @Bean
    public DingdingService dingdingService() {
        return new DingdingService();
    }
}
