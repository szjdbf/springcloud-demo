package com.zlf.cloud.controller;

import com.zlf.cloud.service.feign.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@RestController
public class HiController {

    @Autowired
    private ServiceHi serviceHi;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "feign") String name) {
        return serviceHi.hi(name);
    }

}