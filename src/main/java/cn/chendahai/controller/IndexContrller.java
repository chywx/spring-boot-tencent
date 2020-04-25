package cn.chendahai.controller;

import io.swagger.annotations.Api;
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
public class IndexContrller {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "forward:/doc.html";
    }

}
