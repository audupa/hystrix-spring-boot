package com.intuit.springboot;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        /*System.setProperty("archaius.configurationSource.additionalUrls",
                    "file:///Users/audupa/work/learning/spring-boot/src/main/resources/config12.properties");*/
        //to overrride the Initial delay in milliseconds of reading from the configuration source(best way is to pass as part of java arguments)
        System.setProperty("archaius.fixedDelayPollingScheduler.initialDelayMills",
                    "5000");//by default it is 30000
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }

}
