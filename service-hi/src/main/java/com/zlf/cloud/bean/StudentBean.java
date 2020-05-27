package com.zlf.cloud.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhanglifang
 * @date 2020/5/27
 */
@Component
@Scope("singleton")
@Slf4j
public class StudentBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {


    public StudentBean() {
        log.info("调用了无参构造方法");
    }


    @PostConstruct
    public void postConstruct() {
        log.info("调用了postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("调用了preDestroy");
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("调用了setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("调用了setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        log.info("调用了setBeanName");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("调用了afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("调用了destroy");
    }
}