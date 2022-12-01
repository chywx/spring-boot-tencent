package cn.chendahai.service.impl;

import cn.chendahai.service.LenovoService;
import org.springframework.stereotype.Service;

@Service
public class LenovoServiceImpl {
    public String f1(String str) {
        return "lenovo - " + str;
    }
}
