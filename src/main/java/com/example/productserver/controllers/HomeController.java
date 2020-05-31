package com.example.productserver.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Value("1.0.0")
    private String appVersion;
    @Value("welcome!")
    private String greeting;
    @Value("/products")
    private String productsLoc;


    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        //map.put("app-version",appVersion);
        map.put("Products API", productsLoc);
        return map;
    }
}
