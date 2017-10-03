package com.intuit.springboot.controller;

import com.intuit.springboot.api.HystrixApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.rmi.RemoteException;
import java.util.List;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixApi hystrixApi;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public List<String> doTest() throws RemoteException {
        return hystrixApi.doTest();
    }

    @RequestMapping(value = "/getData")
    public List<String> getData() throws RemoteException {
        return hystrixApi.getData();
    }
}
