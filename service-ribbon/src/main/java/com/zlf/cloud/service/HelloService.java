package com.zlf.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        //远程调用service-hi
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

}