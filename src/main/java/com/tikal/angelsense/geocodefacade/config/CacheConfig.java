package com.tikal.angelsense.geocodefacade.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

	@Value("${redis.host}")
	private String redisHost;
	
	@Value("${redis.port}")
	private int redisPort;
	
	// 0 is no expiration
	@Value("${expirationTimeInSeconds:0}")
	private int expirationTimeInSeconds;
	
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		final JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setHostName(redisHost);
		redisConnectionFactory.setPort(redisPort);
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(final RedisConnectionFactory cf) {
		final RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}

	@Bean
	public CacheManager cacheManager(final RedisTemplate redisTemplate) {
		final RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
		cacheManager.setDefaultExpiration(expirationTimeInSeconds);
		return cacheManager;
	}
}
