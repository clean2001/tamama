package org.tamama.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonProvider {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private String redisPort;

    public RedissonClient createClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(redisHost + ":" + redisPort);
        return Redisson.create(config);
    }
}
