package cn.chendahai.controller;

import cn.chendahai.dingding.service.DingdingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/22 0022
 */
@RestController
@RequestMapping("/dingding")
public class DingdingController {

    @Autowired
    private DingdingService dingdingService;

    @GetMapping("/send")
    public void sendMsg() {
        dingdingService.sendByTokenAndPhone("chy:" + System.currentTimeMillis(), "token", "13121939122");
    }

}
