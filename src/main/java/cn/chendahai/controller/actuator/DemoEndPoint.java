package cn.chendahai.controller.actuator;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/**
 * @author chy
 * @date 2021年07月22日 上午 10:33
 */
@Component
@Endpoint(id = "demo")
public class DemoEndPoint {

    @ReadOperation
    public Map<String, String> hello() {
        Map<String, String> result = new HashMap<>();
        result.put("作者", "chenhaiyang");
        result.put("秃头", "false");
        return result;
    }
}
