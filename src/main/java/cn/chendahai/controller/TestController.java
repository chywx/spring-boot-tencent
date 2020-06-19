package cn.chendahai.controller;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/19 0019
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/t1")
    public String t1() throws InterruptedException {
        System.out.println("t1 start");
        System.out.println(new Date());
        Thread.sleep(10000);
        System.out.println("t1 end");
        return "t1->ok!" + new Date();
    }

}
