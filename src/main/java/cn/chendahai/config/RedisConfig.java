package cn.chendahai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author chy
 * @date 2021年07月27日 上午 11:16
 */
@Configuration
public class RedisConfig {

    // 使用Jackson2JsonRedisSerialize替换默认JDK序列化
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash的hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public DefaultRedisScript<Long> stockScript() {
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setLocation(new ClassPathResource("stock.lua"));
        script.setResultType(Long.class);
        return script;
    }
}
