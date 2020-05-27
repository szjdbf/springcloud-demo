package com.zlf.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix//开启断路器
@Slf4j
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(defaultValue = "visitor") String name) {
        Random random = new Random();
        //模拟异常
        if (3 == random.nextInt(5)) {
            log.error("出现异常");
            throw new RuntimeException();
        }
        log.info("正常");
        return "hi " + name + ", I am from port : " + port;
    }

    //当home方法出现异常时会调用该方法返回结果
    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }

    @GetMapping("/shutdown")
    public String shutdown() {
        System.exit(1);
        return "OK";
    }


}