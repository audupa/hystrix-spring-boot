package com.intuit.springboot.api;

import java.rmi.RemoteException;

public interface HystrixApi {

    String remoteCall(String request) throws RemoteException;

    String fallbackRemoteCall(String request);


}