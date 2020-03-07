package com.hzm.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.PropertyAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author : hzm
 * @date : 2020-03-07 23:07
 */
@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfig {
    @Value("${spring.redis.pool.maxWaitMills}")
    private String maxWaitMills;
    @Value("${spring.redis.pool.maxIdle}")
    private String maxIdle;
    @Value("${spring.redis.pool.minIdle}")
    private String minIdle;
    @Value("${spring.redis.dataBase}")
    private String dataBase;
    @Value("${spring.redis.hostName}")
    private String hostName;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.timeout}")
    private String timeout;
    @Autowired
    private JedisPoolConfig jedisPoolConfig;
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(Long.valueOf(this.maxWaitMills));
        poolConfig.setMaxIdle(Integer.valueOf(this.maxIdle));
        poolConfig.setMinIdle(Integer.valueOf(this.minIdle));
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestOnCreate(true);
        poolConfig.setTestWhileIdle(true);
        return poolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory(jedisPoolConfig);
        factory.setDatabase(Integer.valueOf(dataBase));
        factory.setHostName(this.hostName);
        factory.setPort(Integer.valueOf(this.port));
        factory.setTimeout(Integer.valueOf(this.timeout));
        return factory;

    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
//        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        serializer.setObjectMapper(objectMapper);
        redisTemplate.setKeySerializer(StringRedisSerializer.UTF_8);
        redisTemplate.setValueSerializer(StringRedisSerializer.UTF_8);
        redisTemplate.setHashKeySerializer(StringRedisSerializer.UTF_8);
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        return redisTemplate;
    }
}
