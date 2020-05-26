package com.zlf.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * @author zhanglifang
 * @date 2020/5/26
 */
@Configuration
@Slf4j
public class RedisRateLimiterConfig {

    /**
     * 通过请求参数username限流
     */
//    @Bean("userKeyResolver")
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getQueryParams().getFirst("username")));
//    }

    /**
     * 使用redis通过ip限流
     */
    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            System.out.println(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
            return Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostName());
        };
    }

}