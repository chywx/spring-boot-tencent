package cn.chendahai.controller;

import cn.chendahai.entity.MiaoShaGoods;
import cn.chendahai.service.MiaoShaGoodsService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chy
 * @date 2021年07月27日 上午 11:10
 */
@RestController
@RequestMapping("/ms")
@Api(tags = "秒杀")
public class MiaoShaGoodsController {

    private Logger logger = LoggerFactory.getLogger(MiaoShaGoodsController.class);

    @Autowired
    MiaoShaGoodsService miaoShaGoodsService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    DefaultRedisScript<Long> stockScript;

    @ApiOperation("根据id查询商品信息")
    @GetMapping("/{id}")
    public MiaoShaGoods getById(@PathVariable(name = "id") Integer id) {

        MiaoShaGoods miaoShaGoods = miaoShaGoodsService.getById(id);
        logger.info("goods:{}", JSONObject.toJSONString(miaoShaGoods));
        return miaoShaGoods;

    }

    @ApiOperation("测试redis")
    @GetMapping("/redis/opera/{kv}")
    public String redisOpera(@PathVariable(name = "kv") String kv) {

        redisTemplate.opsForValue().set(kv, kv);
        String value = redisTemplate.opsForValue().get(kv);
        return value;

    }

    /**
     * 会有问题，并发会导致库存变成-的
     */
    @ApiOperation("redis秒杀")
    @GetMapping("/miaosha")
    public String miaosha() {

        String s = redisTemplate.opsForValue().get("goods:sum");

        if (Integer.parseInt(s) > 0) {
            Long sum = redisTemplate.opsForValue().increment("goods:sum", -1);
            System.out.println("sum:" + sum);
        } else {
            System.out.println("failed");
        }

        return "抢购完毕";
    }

    /**
     * 通过lua脚本实现，完美，可以保证原子性
     */
    @ApiOperation("redis秒杀")
    @GetMapping("/miaosha2")
    public String miaosha2() {

        List<String> keys = new ArrayList<>();
        keys.add("goods:sum");

        Long execute = redisTemplate.execute(stockScript, keys);

        if (execute > 0) {
            System.out.println("success:" + execute);
        } else {
            System.out.println("failed");
        }

        return "抢购完毕2";
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

}
