package cn.chendahai.config;

import cn.chendahai.entity.Sport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration
public class TestConfig {

    @Bean
    @Scope("prototype")
    public Sport testSport() {
        Sport sport = new Sport();
        sport.setAvatar(UUID.randomUUID().toString());
        return sport;
    }

}
