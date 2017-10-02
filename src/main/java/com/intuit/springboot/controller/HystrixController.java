package com.intuit.springboot.controller;

import com.intuit.springboot.api.HystrixApi;
import com.intuit.springboot.entity.Student;
import com.intuit.springboot.service.HystrixService;
import com.intuit.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.rmi.RemoteException;
import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private HystrixApi hystrixApi;

    @RequestMapping(method = RequestMethod.GET)
    public String callRemoteService() throws RemoteException {
        return hystrixApi.remoteCall("Test");
    }
}
