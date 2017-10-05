package com.intuit.springboot.service;

import com.intuit.springboot.api.HystrixApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HystrixServiceImpl implements HystrixApi{

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    //private static final int thread1 = DynamicPropertyFactory.getInstance().getIntProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", 0).get();

    /*@HystrixCommand(fallbackMethod = "getDataFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
    public List<String> doTest(){
        return restTemplate.getForObject("http://localhost:8080/hystrix/getData", List.class);

    }*/

    @HystrixCommand(fallbackMethod = "getDataFallBack", groupKey = "TestCommandGroup", commandKey = "testCommandKey")
    public List<String> doTest(){
        return restTemplate.getForObject("http://localhost:8080/hystrix/getData", List.class);

    }

    @HystrixCommand(groupKey = "TestCommandGroup", commandKey = "abcCommandKey")
    public List<String> getData() throws RemoteException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<String>();
        list.add("Live Data 1");
        list.add("Live Data 2");
        list.add("Live Data 3");
        return list;
    }

    public List<String> getDataFallBack()  {
            List<String> list = new ArrayList<String>();
            list.add("FallBack Data 1");
            list.add("FallBack Data 2");
            list.add("FallBack Data 3");
            return list;
    }
}
