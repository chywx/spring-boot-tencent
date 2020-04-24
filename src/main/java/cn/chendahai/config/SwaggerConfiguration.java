package cn.chendahai.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/24 0024
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {


    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            //分组名称
            .groupName("2.X版本")
            .select()
            //这里指定Controller扫描包路径
            .apis(RequestHandlerSelectors.basePackage("cn.chendahai.controller"))
            .paths(PathSelectors.any())
            .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("springboot利用swagger构建api文档",
            "简单优雅的restfun风格",
            "1.0.0",
            "http://localhost:5005/doc.html",
            "陈大海接口文档",
            "license",
            "license url"
        );
        return apiInfo;
    }


}
