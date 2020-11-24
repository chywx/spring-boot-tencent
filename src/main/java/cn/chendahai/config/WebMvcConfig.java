//package cn.chendahai.config;
//
//import java.util.Date;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * 功能描述
// *
// * @author chy
// * @date 2020/5/21 0021
// */
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        System.out.println("hello>>>" + new Date());
//        registry.addMapping("/**")
//            .allowedOrigins("*")
//            .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//            .maxAge(3600)
//            .allowCredentials(true);
//    }
//
//}
