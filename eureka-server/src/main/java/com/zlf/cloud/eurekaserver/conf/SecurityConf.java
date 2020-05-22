package com.zlf.cloud.eurekaserver.conf;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhanglifang
 * @date 2020/5/22
 */
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);

        http.csrf().disable();

    }
}