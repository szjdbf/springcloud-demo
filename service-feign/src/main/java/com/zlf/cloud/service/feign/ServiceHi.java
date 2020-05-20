package com.zlf.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@FeignClient(value = "service-hi", fallback = ServiceHiHystrix.class)//使用feign远程调用service-hi服务
public interface ServiceHi {

    @GetMapping("/hi")
    String hi(@RequestParam("name") String name);

}