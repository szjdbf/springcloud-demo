package com.zlf.cloud.service.feign;

import org.springframework.stereotype.Component;

/**
 * @author zhanglifang
 * @date 2020/5/20
 */
@Component//feign远程调用快速失败的方法
public class ServiceHiHystrix implements ServiceHi {

    @Override
    public String hi(String name) {
        return "sorry," + name;
    }
}