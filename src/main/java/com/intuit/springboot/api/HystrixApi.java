package com.intuit.springboot.api;

import java.rmi.RemoteException;
import java.util.List;

public interface HystrixApi {

    List<String> doTest() throws RemoteException;

    List<String> getData() throws RemoteException;

    List<String> getDataFallBack();

}