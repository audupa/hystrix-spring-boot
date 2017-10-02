package com.intuit.sprintboot.config;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
public class HystrixConfigConstants {

    @Bean
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }

    public static final String HYSTRIX_TIMEOUT_PROPERTY_KEY = "execution.isolation.thread.timeoutInMilliseconds";

    public static final String HYSTRIX_TIMEOUT_PROPERTY_VALUE = "1000";
}

