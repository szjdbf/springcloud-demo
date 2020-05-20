package com.zlf.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public String home(@RequestParam(defaultValue = "visitor") String name) {
        return "hi " + name + ", i am from port : " + port;
    }

}