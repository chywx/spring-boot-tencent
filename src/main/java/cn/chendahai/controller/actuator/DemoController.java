package cn.chendahai.controller.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chy
 * @date 2021年07月22日 上午 10:23
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    private static final Counter METRICS_DEMO_COUNT = Counter
        .builder("demo.visit.count") // 指标的名字
        .description("demo 访问次数")
        .baseUnit("次")// 指标的单位
        .tag("test", "nicai")// 自定义标签
        .register(Metrics.globalRegistry);// 注册到全局 MeterRegistry 指标注册表

    @GetMapping("/visit")
    public String visit() {
        // 增加次数
        METRICS_DEMO_COUNT.increment();
        return "Demo 示例";
    }

}
