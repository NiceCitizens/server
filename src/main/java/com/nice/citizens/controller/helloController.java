package com.nice.citizens.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @GetMapping("/")
    public String hello(){
        System.out.println("hello");
        return "hello";
    }
}
