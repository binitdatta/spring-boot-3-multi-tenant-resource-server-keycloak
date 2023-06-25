package com.rollingstone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure/multitenant/hello")
    public String sayHello(){
        return "Hi There! Welcome to The KeyCloak Spring Boot 3, Spring Security 6 Multi Tenant Thymeleaf Driven CRUD Application";
    }
}
