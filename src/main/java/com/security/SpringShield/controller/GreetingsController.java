package com.security.SpringShield.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello! this is Lukesh Gadhane.";
    }
}
