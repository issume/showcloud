package com.showcloud.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * Created by WangIJia on 2016/11/8.
 */
@Configuration
@EnableCaching
public class RedisCacheCofig  extends CachingConfigurerSupport {

    /**
     * 默认使用@Cacheable 注解的方法，
     * key 生成策略默认使用的是 参数名+参数值
     * 如果参数名+参数值重复，就会出问题
     * 解决办法：使用自定义缓存策略
     * 类名+方法名+参数值
     *
     * */
    @Bean
    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName()+"_");
//                sb.append(method.getName()+"_");
//                for (Object obj : params) {
//                    sb.append(obj.toString()+"_");
//                }
//                return sb.toString();
//            }
//        };

        return new DefaultKeyGenerator();
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){

        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        cacheManager.setDefaultExpiration(7200);//设置默认过期时间 单位 秒
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//
//        JedisConnectionFactory jcf = new JedisConnectionFactory();
//        jcf.setHostName("101.200.58.106");
//        jcf.setPassword("0709ABC009");
//        jcf.setPort(6379);
//
//        return jcf;
//
//    }
}
