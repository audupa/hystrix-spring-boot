package com.intuit.springboot.service;

import com.intuit.springboot.api.HystrixApi;
import com.intuit.sprintboot.config.HystrixConfigConstants;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Date;

@Service
public class HystrixService implements HystrixApi{

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixService.class);

    private static long current = System.currentTimeMillis();

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixConfigConstants.HYSTRIX_TIMEOUT_PROPERTY_KEY,
                    value = HystrixConfigConstants.HYSTRIX_TIMEOUT_PROPERTY_VALUE)
            // time after which Command will timeout and halt the execution
    })
    public String remoteCall(String request) throws RemoteException {

        long now = (System.currentTimeMillis() - current)/1000;
        if(now > 15) {
            LOGGER.info("Processing  call throwing exception :::: " + now + " ::::: " + request + " at " + new Date());
            current = System.currentTimeMillis();
            throw new RemoteException("Throwing a remote exception " + now);

        } else {
            LOGGER.info("Processing  remote call ::::  " + now + " ::::: " + request + " at " + new Date());
            return "Remote response: " + request;

        }
    }


    public String fallbackRemoteCall(String request)  {
        LOGGER.info("Processing  fallback call :::: " + request  + " at " + new Date());
        return "stubbed Fallback Response";
    }
}
