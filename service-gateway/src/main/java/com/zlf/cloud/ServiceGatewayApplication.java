package com.zlf.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifang
 * @date 2020/5/21
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceGatewayApplication.class, args);
    }

    /**
     * 服务降级的控制器处理
     */
    @GetMapping("/fallback")
    public Object fallback() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", null);
        result.put("message", "get request fallback!");
        result.put("code", 500);
        return result;
    }

}
