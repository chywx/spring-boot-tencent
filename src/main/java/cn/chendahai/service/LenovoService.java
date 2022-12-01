package cn.chendahai.service;

import org.springframework.web.bind.annotation.GetMapping;

public interface LenovoService {

    @GetMapping("/f1")
    String f1(String str);

}
