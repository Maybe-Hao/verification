package com.hao.test.duanxin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//将对象序列化存储到Redis中
//@Configuration
public class RedisConfig {
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
//        //key序列化
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        //value序列化
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());//通用的json转换，传过去的也是json对象，但不用传类对象
//        //hash类型key序列化
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        //hash类型value序列化
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//
//
//        //注入连接工厂
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        return redisTemplate;
//    }
@Bean(name="redisTemplate")
public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, String> template = new RedisTemplate<>();
    RedisSerializer<String> redisSerializer = new StringRedisSerializer();
    template.setConnectionFactory(factory);
    //key序列化方式
    template.setKeySerializer(redisSerializer);
    //value序列化
    template.setValueSerializer(redisSerializer);
    //value hashmap序列化
    template.setHashValueSerializer(redisSerializer);
    //key haspmap序列化
    template.setHashKeySerializer(redisSerializer);
    //
    return template;
}
}
