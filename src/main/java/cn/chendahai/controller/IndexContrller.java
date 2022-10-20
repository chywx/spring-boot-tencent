package cn.chendahai.controller;

import io.swagger.annotations.Api;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/22 0022
 */
@Api(tags = "首页")
@Controller
public class IndexContrller implements BeanFactoryAware, EnvironmentAware {


    @GetMapping(value = {"/", "/index"})
    public String index() {
        System.out.println("index");
        return "forward:/doc.html";
    }

    @GetMapping("/wiki")
    public void wiki(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://wiki.idawa.cn/#/knowledge/AllUpdates");
    }

    public static void main(String[] args) {
        BigDecimal couponAmount = new BigDecimal("80").multiply(BigDecimal.ONE.subtract(new BigDecimal(0.8 + "")));
        System.out.println(couponAmount);

        System.out.println(new BigDecimal(1 - 0.8));

        IndexContrller indexContrller = new IndexContrller();
        System.out.println(indexContrller instanceof BeanFactoryAware);
        System.out.println(indexContrller instanceof EnvironmentAware);
        System.out.println(indexContrller instanceof BeanFactory);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {

    }
}
