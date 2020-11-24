package cn.chendahai.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/8/22 0022
 */
@Controller
//@CrossOrigin(value = "*", allowCredentials = "true")
//@CrossOrigin(value = "*")
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("/test")
    public String index(Model model) {
        System.out.println("enter test");
        model.addAttribute("name", "Dylan");
        return "test";

    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello" + new Date());
        return "hello";

    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(HttpServletRequest request, HttpServletResponse response) {
        request.getSession();
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println(new Date());
        return "hello world";
    }

}
