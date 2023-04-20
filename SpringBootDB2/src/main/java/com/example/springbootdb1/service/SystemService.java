package com.example.springbootdb1.service;

import java.util.HashMap;

public class SystemService {

    private String name;
    private HashMap<String, String> storage;
    private HashMap<String, Integer> profiles;

    public SystemService() {
        super();
    }

    public SystemService(String name) {
        this.name = name;
    }
}
