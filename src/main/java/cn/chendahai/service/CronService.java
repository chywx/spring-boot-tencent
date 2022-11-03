package cn.chendahai.service;

import cn.chendahai.util.DateUtil;
import cn.chendahai.websocket.WebSocketServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author: Dylan
 * @date: 2022/11/3 18:56
 */
@EnableScheduling
@Service
public class CronService {

    @Scheduled(cron = "0/5 * * * * ?")
    public void pushDemo() {
        try {
            WebSocketServer.sendInfo("定时群发→当前时间：" + DateUtil.getCurrentDateStr(DateUtil.STANDARD_FORMAT));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
