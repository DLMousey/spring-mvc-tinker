package com.enderstudy.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    public String getHelloMessage(String user) {
        return "Hello " + user;
    }

    public String getHelloMessage() {
        return "Welcome to this Demo application.";
    }
}
