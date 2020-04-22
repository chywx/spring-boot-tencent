package cn.chendahai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/22 0022
 */
@RestController
public class IndexContrller {

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

}
