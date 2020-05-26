package com.zlf.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglifang
 * @date 2020/5/26
 */
@Configuration
public class GatewayConfig {

    /**
     * 使用java配置路由信息
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("headers",r -> r.path("/headers")
                        .uri("http://httpbin.org/"))
                .build();
    }

}