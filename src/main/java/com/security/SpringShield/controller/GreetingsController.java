package com.security.SpringShield.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello! this is Lukesh Gadhane.";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String getUserRole(){
        return "Hello User! this is Lukesh Gadhane.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminRole(){
        return "Hello Admin! this is Lukesh Gadhane.";
    }
}
