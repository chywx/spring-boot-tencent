package cn.chendahai.controller;

import cn.chendahai.service.LenovoService;
import cn.chendahai.service.impl.LenovoServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "lenovo")
@RestController
@RequestMapping("/lenovo")
public class LenovoController implements LenovoService {

    @Autowired
    LenovoServiceImpl lenovoService;

    @Override
    public String f1(String str) {
        return lenovoService.f1(str);
    }
}
