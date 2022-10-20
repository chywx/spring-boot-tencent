package cn.chendahai.controller;

import cn.chendahai.service.SportService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trans")
public class TransactionalTest {

    @Autowired
    private SportService sportService;

    @GetMapping("/test1")
    public String test1() {
        int a = sportService.updateAvatar(1, "aaa");
        System.out.println("updateAvatar:" + a);

        int b = sportService.updateDescription(2, "bbb");
        System.out.println("updateDescription:" + b);


        return "t1->ok!" + new Date();
    }

}
